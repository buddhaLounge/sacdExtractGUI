package it.casa.sacdextract.gui.listeners;

import it.casa.sacdextract.gui.MainPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class RunButtonListener implements ActionListener {

    private MainPanel mainPanel;

    private JRadioButton multiChannelBtn;

    private List<String> filesList = new ArrayList<>();

    private static final String CMD_STEREO = "\"%s\" -2 -s -A -a -i \"%s\"";

    private static final String CMD_MULTI_CHANNEL = "\"%s\" -m -s -A -a -i \"%s\"";

    private PrintStream ps;

    public RunButtonListener(MainPanel mainPanel, JRadioButton multiChannelBtn, PrintStream ps) {
        this.mainPanel = mainPanel;
        this.multiChannelBtn = multiChannelBtn;
        this.ps = ps;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < mainPanel.getFilesPanel().getList().getModel().getSize(); i++) {
            String item = mainPanel.getFilesPanel().getList().getModel().getElementAt(i);
            filesList.add(item);
            System.out.printf("%nItem %d selected: %s", i+1, item);
        }

        for (String filePath : filesList) {
            String cmd;
            if (multiChannelBtn.isSelected()) {
                cmd = String.format(CMD_MULTI_CHANNEL, mainPanel.getExecutablePanel().getSacdField().getText(), filePath);
            } else {
                cmd = String.format(CMD_STEREO, mainPanel.getExecutablePanel().getSacdField().getText(), filePath);
            }
            System.out.printf("%n%s", cmd);
            ProcessBuilder builder = new ProcessBuilder(cmd);
            try {
                var process = builder.start();
                printResults(process);
            } catch (IOException ex) {
                ex.printStackTrace(ps);
            }
        }
    }

    private static void printResults(Process process) throws IOException {
        try (var reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.printf("%n%s", line);
            }
        }
    }

}
