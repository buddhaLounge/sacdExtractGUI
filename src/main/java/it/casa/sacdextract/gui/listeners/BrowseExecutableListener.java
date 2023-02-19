package it.casa.sacdextract.gui.listeners;

import it.casa.sacdextract.gui.MainPanel;
import it.casa.sacdextract.gui.panels.ExecutablePanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class BrowseExecutableListener implements ActionListener {

    public MainPanel mainPanel;

    public JFileChooser sacdExecutableFileChooser;

    public ExecutablePanel executablePanel;

    public JTextField pathField;

    private String filename;

    public BrowseExecutableListener(ExecutablePanel executablePanel, MainPanel mainPanel,
                                    JFileChooser sacdExecutableFileChooser, JTextField pathField, String filename) {
        this.mainPanel = mainPanel;
        this.sacdExecutableFileChooser = sacdExecutableFileChooser;
        this.executablePanel = executablePanel;
        this.pathField = pathField;
        this.filename = filename;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int returnVal = sacdExecutableFileChooser.showOpenDialog(mainPanel);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = sacdExecutableFileChooser.getSelectedFile();
            if(file.getName().contains(filename)){
                pathField.setText(file.getAbsolutePath());
                System.out.printf("SACD executable path set: %s%n", file.getAbsolutePath());
                mainPanel.getFilesPanel().getListISOFiles().setEnabled(true);
                mainPanel.getFilesPanel().getAddBtn().setEnabled(true);
                mainPanel.getFilesPanel().getRemoveBtn().setEnabled(true);
                mainPanel.getOptionsPanel().getRunBtn().setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(mainPanel, String.format("You didn't choose a correct %s file", filename),
                        "Wrong executable", JOptionPane.ERROR_MESSAGE, null);
            }
        }
    }
}
