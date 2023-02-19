package it.casa.sacdextract.gui.panels;

import it.casa.sacdextract.gui.MainPanel;
import it.casa.sacdextract.gui.listeners.RunButtonListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.BorderUIResource;
import java.awt.*;
import java.io.PrintStream;

public class OptionsPanel extends JPanel {

    private BorderUIResource.TitledBorderUIResource optionsBorder = new BorderUIResource.TitledBorderUIResource(
            new EmptyBorder(5, 0, 5, 0), "Options for conversion",
            TitledBorder.CENTER, TitledBorder.CENTER);

    private JRadioButton stereoBtn = new JRadioButton("Stereo");

    private JRadioButton multiChannelBtn = new JRadioButton("Multi-channel");

    private JButton runBtn = new JButton("Run");

    private ButtonGroup group = new ButtonGroup();

    public OptionsPanel(MainPanel mainPanel, PrintStream ps) {
        super();
        setBorder(optionsBorder);
        setLayout(new GridLayout(1,4));

        group.add(stereoBtn);
        group.add(multiChannelBtn);
        stereoBtn.setSelected(true);
        runBtn.setEnabled(false);
        runBtn.addActionListener(new RunButtonListener(mainPanel, multiChannelBtn, ps));

        JPanel channelPanel = new JPanel();
        channelPanel.setLayout(new BoxLayout(channelPanel, BoxLayout.Y_AXIS));
        channelPanel.add(stereoBtn);
        channelPanel.add(multiChannelBtn);

        add(channelPanel);
        add(runBtn);
    }

    public JButton getRunBtn() {
        return runBtn;
    }
}
