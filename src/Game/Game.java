package Game;

import javax.swing.*;
import java.util.Scanner;

public class Game extends JFrame {

    private final Display display;

    public Game() {
        super("Game");
        display = new Display();
        Scanner scanner = new Scanner(System.in);
        int spieleranzahl;

        System.out.println("Willkommen zu Mensch ärgere dich nicht!");
        System.out.print("Bitte geben Sie die Spieleranzahl ein (1-4): ");

        do {
            spieleranzahl = scanner.nextInt();
            if (spieleranzahl < 1 || spieleranzahl > 4) {
                System.out.print("Ungültige Spieleranzahl. Bitte geben Sie eine Zahl zwischen 1 und 4 ein: ");
            }
        } while (spieleranzahl < 1 || spieleranzahl > 4);
        System.out.println("Sie haben " + spieleranzahl + " Spieler ausgewählt.");

        JButton b1 = new JButton("Wuerfeln");
        DiceRollHandler rollHandler = new DiceRollHandler(display);
        b1.addActionListener(rollHandler);

        JButton b2 = new JButton("Neustart");

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
        new Game();
    }
}