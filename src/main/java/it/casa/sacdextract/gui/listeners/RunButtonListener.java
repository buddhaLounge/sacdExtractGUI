package it.casa.sacdextract.gui.listeners;

import it.casa.sacdextract.gui.MainPanel;
import org.apache.commons.lang3.StringUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class RunButtonListener implements ActionListener {

    private MainPanel mainPanel;

    private JRadioButton multiChannelBtn;

    private List<String> filesList = new ArrayList<>();

    private PrintStream ps;

    public RunButtonListener(MainPanel mainPanel, JRadioButton multiChannelBtn, PrintStream ps) {
        this.mainPanel = mainPanel;
        this.multiChannelBtn = multiChannelBtn;
        this.ps = ps;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        IntStream.range(0, mainPanel.getFilesPanel().getList().getModel().getSize()).forEach(p -> {
            var item = mainPanel.getFilesPanel().getList().getModel().getElementAt(p);
            filesList.add(item);
            System.out.printf("%nItem %d selected: %s", p+1, item);
        });

        List<String> cmd;
        for (String filePath : filesList) {
            cmd = new ArrayList<>(Collections.singleton(mainPanel.getExecutablePanel().getSacdField().getText()));

            if(multiChannelBtn.isSelected())
                cmd.add("--mch-tracks");
            else cmd.add("--2ch-tracks");

            if (mainPanel.getOptionsPanel().getDsdiffEditMasterBtn().isSelected())
                cmd.add("--output-dsdiff-em");
            else if (mainPanel.getOptionsPanel().getDsdiffBtn().isSelected())
                cmd.add("--output-dsdiff");
            else if (mainPanel.getOptionsPanel().getDsfBtn().isSelected())
                cmd.add("--output-dsf");
            else cmd.add("--output-iso");

            if (mainPanel.getOptionsPanel().getExportCueChkBox().isSelected())
                cmd.add("--export-cue");
            if (mainPanel.getOptionsPanel().getPrintChkBox().isSelected())
                cmd.add("--print");
            if (mainPanel.getOptionsPanel().getArtistChkBox().isSelected())
                cmd.add("--artist");
            if (mainPanel.getOptionsPanel().getPerformerChkBox().isSelected())
                cmd.add("--performer");

            cmd.add(String.format("--input \"%s\"", filePath));
            System.out.printf("%n%s", String.join(StringUtils.SPACE, cmd));
            /*var builder = new ProcessBuilder(String.join(StringUtils.SPACE, cmd));
            try {
                var process = builder.start();
                printResults(process);
            } catch (IOException ex) {
                ex.printStackTrace(ps);
            }*/
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
