package Game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.io.PrintStream;
import java.util.Scanner;
import java.awt.*;

public class Game extends JFrame {

    private final Display display;

    public Game() {
        super("Game");
        display = new Display();

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        display.add(scrollPane);

        ConsoleOutputStream consoleOutput = new ConsoleOutputStream(textArea);
        System.setOut(new PrintStream(consoleOutput));
        System.setErr(new PrintStream(consoleOutput));
        
        //System.out.println("Dies ist eine Konsolenausgabe.");
        //System.err.println("Dies ist eine Fehlerausgabe.");

        JButton b1 = new JButton("Wuerfeln");
        DiceRollHandler rollHandler = new DiceRollHandler(display);
        b1.addActionListener(rollHandler);

        JButton b2 = new JButton("Neustart");
        RestartHandler restartHandler = new RestartHandler(this); // Neuer ActionListener
        b2.addActionListener(restartHandler);

        b1.setSize(100, 100);
        b1.setLocation(10,10);

        display.add(b1);
        display.add(b2);

        this.add(display);

        setSize(1920,1080);
        setResizable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
            new AbfrageFenster();

    }
}