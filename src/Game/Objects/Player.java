package Game.Objects;

import Game.Objects.Tile.Tile;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;

public class Player extends Figurenposition implements KeyListener {

    private String state = "Wait";
    private Tile[] steine;

    public Player(double centerX, double centerY, double radius) {

        super(centerX, centerY, radius, Color.YELLOW);

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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
