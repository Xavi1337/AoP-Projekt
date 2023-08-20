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


    public Game(int teilnehmer) {
        super("Mensch Aergere Dich Nicht!");
        display = new Display();
        this.add(display);



        setSize(1920, 1080);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        this.setLayout(new GridLayout(2, 2));

        ConsoleOutputStream consoleOutput = new ConsoleOutputStream(textArea);
        System.setOut(new PrintStream(consoleOutput));
        System.setErr(new PrintStream(consoleOutput));

        JButton b1 = new JButton("Wuerfeln");
        DiceRollHandler rollHandler = new DiceRollHandler(display, teilnehmer);
        b1.addActionListener(rollHandler);

        JButton b2 = new JButton("Neustart");
        RestartHandler restartHandler = new RestartHandler(this); // Neuer ActionListener
        b2.addActionListener(restartHandler);






        this.add(b1);
        this.add(scrollPane);
        this.add(b2);

        this.revalidate();
        this.repaint();



    }

    public static void main(String[] args) {
            new AbfrageFenster();

    }
}