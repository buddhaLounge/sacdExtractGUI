package it.casa.sacdextract.gui;

import javax.swing.*;
import java.io.OutputStream;

public class ConsoleStream extends OutputStream {

    private JTextArea textArea;

    public ConsoleStream(JTextArea textArea) {
        this.textArea = textArea;
    }

    @Override
    public void write(int b) {
        // redirects data to the text area
        textArea.append(String.valueOf((char)b));
        // scrolls the text area to the end of data
        textArea.setCaretPosition(textArea.getDocument().getLength());
    }
}
