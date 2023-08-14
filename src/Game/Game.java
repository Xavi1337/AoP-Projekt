package Game;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.Random;
import javax.swing.*;
import java.util.Scanner;
import Game.Objects.*;
import Game.GameMap;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Game.Objects.Tile.SpielerRot;
import Game.Objects.Tile.Tile;


public class Game extends JFrame{


    private final Display display;
    private final GameMap map;
    private final Player1 player1;
    private final Player2 player2;
    private final Player3 player3;
    private final Player4 player4;


    Color yellowboard = new Color(204, 204, 0);

    public Game() {
        super("Game");
        display = new Display(this);
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
        DiceRollHandler rollHandler = new DiceRollHandler();
        b1.addActionListener(rollHandler);

        JButton b2 = new JButton("Neustart");

        display.add(b1);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int diceRoll = rollDice();
                System.out.println(diceRoll);
            }
        });






        display.add(b2);





        map = new GameMap(50);
        player1 = new Player1(this, 8.5, 12.5, 0.375);
        player2 = new Player2(this, 7.5, 12.5, 0.375);
        player3 = new Player3(this, 6.5, 12.5, 0.375);
        player4 = new Player4(this, 5.5, 12.5, 0.375);






        setSize(670,700);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

    }
   

    public int rollDice() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }


    public void render(Graphics2D g2) {

        g2.setColor(yellowboard);
        g2.fillRect(0,0, getWidth(), getHeight());

        map.render(g2, map.getTileSize());
        player1.render(g2, map.getTileSize());
        player2.render(g2, map.getTileSize());
        player3.render(g2, map.getTileSize());
        player4.render(g2, map.getTileSize());






    }








    public static void main(String[] args) {
        new Game();




    }




}