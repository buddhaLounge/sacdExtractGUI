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
    private JRadioButton dsdiffEditMasterBtn = new JRadioButton("Philips DSDIFF Edit Master");
    private JRadioButton dsdiffBtn = new JRadioButton("Philips DSDIFF");
    private JRadioButton dsfBtn = new JRadioButton("Sony DSF");
    private JRadioButton rawIsoBtn = new JRadioButton("Raw ISO");

    private JCheckBox exportCueChkBox = new JCheckBox("Export CUE");

    private JCheckBox printChkBox = new JCheckBox("Display disc & track infos");

    private JCheckBox artistChkBox = new JCheckBox("Add artist name in folders");

    private JCheckBox performerChkBox = new JCheckBox("Add performer name in folders");

    private JButton runBtn = new JButton("Run");

    private ButtonGroup channelGroup = new ButtonGroup();
    private ButtonGroup outputGroup = new ButtonGroup();

    public OptionsPanel(MainPanel mainPanel, PrintStream ps) {
        super();
        setBorder(optionsBorder);
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));

        channelGroup.add(stereoBtn);
        channelGroup.add(multiChannelBtn);
        stereoBtn.setSelected(true);
        runBtn.setEnabled(false);
        runBtn.addActionListener(new RunButtonListener(mainPanel, multiChannelBtn, ps));

        JPanel channelPanel = new JPanel();
        channelPanel.setLayout(new GridLayout(2,1));
        channelPanel.add(stereoBtn);
        channelPanel.add(multiChannelBtn);

        outputGroup.add(dsdiffEditMasterBtn);
        outputGroup.add(dsdiffBtn);
        outputGroup.add(dsfBtn);
        outputGroup.add(rawIsoBtn);
        dsfBtn.setSelected(true);

        JPanel outputPanel = new JPanel();
        outputPanel.setLayout(new GridLayout(2,4));
        outputPanel.add(dsdiffEditMasterBtn);
        outputPanel.add(dsdiffBtn);
        outputPanel.add(dsfBtn);
        outputPanel.add(rawIsoBtn);
        outputPanel.add(exportCueChkBox);
        outputPanel.add(printChkBox);
        outputPanel.add(artistChkBox);
        outputPanel.add(performerChkBox);

        add(channelPanel);
        add(outputPanel);
        add(runBtn);
    }

    public JButton getRunBtn() {
        return runBtn;
    }

    public JRadioButton getDsdiffEditMasterBtn() {
        return dsdiffEditMasterBtn;
    }

    public JRadioButton getDsdiffBtn() {
        return dsdiffBtn;
    }

    public JRadioButton getDsfBtn() {
        return dsfBtn;
    }

    public JRadioButton getRawIsoBtn() {
        return rawIsoBtn;
    }

    public JCheckBox getExportCueChkBox() {
        return exportCueChkBox;
    }

    public JCheckBox getPrintChkBox() {
        return printChkBox;
    }

    public JCheckBox getArtistChkBox() {
        return artistChkBox;
    }

    public JCheckBox getPerformerChkBox() {
        return performerChkBox;
    }
}
