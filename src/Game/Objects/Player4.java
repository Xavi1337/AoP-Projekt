package Game.Objects;

import Game.Game;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;

import static java.awt.Color.yellow;

public class Player4 extends Figuren implements KeyListener {
    public Player4(Game game, double centerX, double centerY, double radius) {
        super(game, centerX, centerY, radius, Color.RED);
    }

    @Override
    public void render(Graphics2D g, int tileSize) {
        double centerXOnScreen = centerX * tileSize;
        double centerYOnScreen = centerY * tileSize;
        double radiusOnScreen = radius * tileSize;
        double diameterOnScreen = radiusOnScreen * 2.0;

        g.setColor(color);
        g.fill(new Ellipse2D.Double(centerXOnScreen - radiusOnScreen, centerYOnScreen - radiusOnScreen, diameterOnScreen, diameterOnScreen));
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
