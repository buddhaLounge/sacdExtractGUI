package it.casa.sacdextract;

import it.casa.sacdextract.gui.MainFrame;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class App {

    public static void main( String[] args ) throws UnsupportedLookAndFeelException, ClassNotFoundException,
            InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel(NimbusLookAndFeel.class.getCanonicalName());
        SwingUtilities.invokeLater(() -> new MainFrame("SACDExtractGUI"));
    }

}
