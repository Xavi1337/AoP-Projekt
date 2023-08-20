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

        this.add(display);



        setSize(1920, 1080);
        setResizable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);


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


        b1.setSize(20,20);
        b2.setSize(20,20);



        display.add(scrollPane);
        display.add(b1);
        display.add(b2);

        display.revalidate();
        display.repaint();



    }

    public static void main(String[] args) {
            new AbfrageFenster();

    }
}