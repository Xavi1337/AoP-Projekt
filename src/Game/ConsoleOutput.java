package Game;

import javax.swing.*;
import java.io.IOException;
import java.io.OutputStream;

class ConsoleOutputStream extends OutputStream {
    private JTextArea textArea;

    public ConsoleOutputStream(JTextArea textArea) {
        this.textArea = textArea;
    }

    @Override
    public void write(int b) throws IOException {
        // Schreibe den Byte-Wert in die JTextArea
        textArea.append(String.valueOf((char) b));

        // Scrolle zur letzten Zeile
        textArea.setCaretPosition(textArea.getDocument().getLength());
    }
}
