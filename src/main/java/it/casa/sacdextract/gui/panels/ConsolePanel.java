package it.casa.sacdextract.gui.panels;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.BorderUIResource;

public class ConsolePanel extends JScrollPane {

    private BorderUIResource.TitledBorderUIResource consoleBorder = new BorderUIResource.TitledBorderUIResource(
            new EmptyBorder(5,0,0,0), "Console output",
            TitledBorder.CENTER, TitledBorder.CENTER);

    private JTextArea textArea = new JTextArea(20, 80);

    public ConsolePanel() {
        super();
        setLayout(new ScrollPaneLayout());
        setBorder(consoleBorder);
        textArea.setEditable(false);
        setViewportView(textArea);
    }

    public JTextArea getTextArea() {
        return textArea;
    }
}
