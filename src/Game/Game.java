package Game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.awt.*;

public class Game extends JFrame {

    private final Display display;

    public Game() {
        super("Game");
        display = new Display();



        JButton b1 = new JButton("Wuerfeln");
        DiceRollHandler rollHandler = new DiceRollHandler(display);
        b1.addActionListener(rollHandler);


        JButton b2 = new JButton("Neustart");
        RestartHandler restartHandler = new RestartHandler(this); // Neuer ActionListener
        b2.addActionListener(restartHandler);





        display.add(b1);
        display.add(b2);

        this.add(display);

        setSize(670,700);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);




        setLocationRelativeTo(null);
        setVisible(true);
    }








    public static void main(String[] args) {
            new AbfrageFenster();

    }
}