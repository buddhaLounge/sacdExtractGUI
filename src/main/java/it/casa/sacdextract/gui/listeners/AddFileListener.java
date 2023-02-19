package it.casa.sacdextract.gui.listeners;

import it.casa.sacdextract.gui.MainPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class AddFileListener implements ActionListener {

    private JFileChooser chooser;

    private DefaultListModel<String> filesList;

    private MainPanel panel;

    public AddFileListener(JFileChooser fileChooser, DefaultListModel<String> filesList, MainPanel panel) {
        this.chooser = fileChooser;
        this.filesList = filesList;
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int returnVal = chooser.showOpenDialog(panel);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            filesList.addElement(file.getAbsolutePath());
        }
    }
}
