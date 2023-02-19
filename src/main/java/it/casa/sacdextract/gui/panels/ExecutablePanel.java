package it.casa.sacdextract.gui.panels;

import it.casa.sacdextract.gui.listeners.BrowseExecutableListener;
import it.casa.sacdextract.gui.MainPanel;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.BorderUIResource;
import java.awt.*;

public class ExecutablePanel extends JPanel {

    private Border sacdBorder = new BorderUIResource.TitledBorderUIResource(new EmptyBorder(5,0,5,0),
            "SACD and ffMPEG Executable Path", TitledBorder.CENTER, TitledBorder.CENTER);

    private LayoutManager executableLayout = new BoxLayout(this, BoxLayout.PAGE_AXIS);

    private JTextField sacdField = new JTextField("Press Browse button to set the SACD executable path");

    private JButton browseSACDBtn = new JButton("Browse");

    private JFileChooser sacdExecutableFileChooser = new JFileChooser();

    public ExecutablePanel(MainPanel mainPanel) {
        super();
        setLayout(executableLayout);
        setBorder(sacdBorder);

        JPanel sacdPanel = new JPanel();
        sacdPanel.setLayout(new BoxLayout(sacdPanel, BoxLayout.X_AXIS));
        sacdField.setEnabled(false);
        sacdExecutableFileChooser.setDialogTitle("Set SACD executable path");
        sacdExecutableFileChooser.setFileFilter(new FileNameExtensionFilter("sacd_extract.exe", "exe"));
        sacdExecutableFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        browseSACDBtn.addActionListener(new BrowseExecutableListener(this, mainPanel,
                sacdExecutableFileChooser, sacdField, "sacd_extract.exe"));
        sacdPanel.add(sacdField);
        sacdPanel.add(browseSACDBtn);

        add(sacdPanel);
    }

    public JTextField getSacdField() {
        return sacdField;
    }
}
