package it.casa.sacdextract.gui;

import it.casa.sacdextract.gui.panels.ConsolePanel;
import it.casa.sacdextract.gui.panels.ExecutablePanel;
import it.casa.sacdextract.gui.panels.FilesPanel;
import it.casa.sacdextract.gui.panels.OptionsPanel;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.PrintStream;

public class MainPanel extends JPanel {

    private LayoutManager mainLayout = new BoxLayout(this, BoxLayout.Y_AXIS);

    private Border mainBorder = new EmptyBorder(5,5,5,5);

    private ExecutablePanel executablePanel = new ExecutablePanel(this);

    private FilesPanel filesPanel = new FilesPanel(this);

    private ConsolePanel consolePanel = new ConsolePanel();

    private PrintStream out = new PrintStream(new ConsoleStream(consolePanel.getTextArea()));

    private OptionsPanel optionsPanel = new OptionsPanel(this, out);

    public MainPanel() {
        super();
        setLayout(mainLayout);
        setBorder(mainBorder);

        System.setOut(out);
        System.setErr(out);

        add(executablePanel);
        add(filesPanel);
        add(optionsPanel);
        add(consolePanel);
    }

    public ExecutablePanel getExecutablePanel() {
        return executablePanel;
    }

    public FilesPanel getFilesPanel() {
        return filesPanel;
    }

    public OptionsPanel getOptionsPanel() {
        return optionsPanel;
    }

}
