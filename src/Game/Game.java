package Game;

import java.awt.Color;
import java.awt.Graphics2D;
import javax.swing.*;

import Game.Objects.*;


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




        JButton b1 = new JButton("Wuerfeln");
        JButton b2 = new JButton("Neustart");

        display.add(b1);
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