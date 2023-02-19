package it.casa.sacdextract.gui.panels;

import it.casa.sacdextract.gui.MainPanel;
import it.casa.sacdextract.gui.listeners.AddFileListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.BorderUIResource;
import java.awt.*;

public class FilesPanel extends JPanel {

    private DefaultListModel<String> filesList = new DefaultListModel<>();

    private JList<String> list = new JList<>(filesList);

    private JScrollPane listISOFiles = new JScrollPane(list);

    private JPanel buttonPanel = new JPanel();

    private LayoutManager panelLayout = new BoxLayout(this, BoxLayout.X_AXIS);

    private Border filesBorder = new BorderUIResource.TitledBorderUIResource(
            new EmptyBorder(5,0,5,0), "ISO Files",
            TitledBorder.CENTER, TitledBorder.CENTER);

    private JButton addBtn = new JButton("Add");
    private JButton removeBtn = new JButton("Remove");

    private JFileChooser chooser = new JFileChooser();

    public FilesPanel(MainPanel panel) {
        super();
        setLayout(panelLayout);
        setBorder(filesBorder);

        chooser.setDialogTitle("Add ISO File");
        chooser.setFileFilter(new FileNameExtensionFilter("ISO files", "iso"));
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        listISOFiles.setEnabled(false);
        list.setSelectionMode(DefaultListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        addBtn.setEnabled(false);
        addBtn.addActionListener(new AddFileListener(chooser, filesList, panel));

        removeBtn.setEnabled(false);
        removeBtn.addActionListener(e -> list.getSelectedValuesList().forEach(s -> filesList.removeElement(s)));

        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.PAGE_AXIS));
        buttonPanel.add(addBtn);
        buttonPanel.add(removeBtn);
        add(listISOFiles);
        add(buttonPanel);
    }

    public JScrollPane getListISOFiles() {
        return listISOFiles;
    }

    public JButton getAddBtn() {
        return addBtn;
    }

    public JButton getRemoveBtn() {
        return removeBtn;
    }

    public JList<String> getList() {
        return list;
    }
}
