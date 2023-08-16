package Game.Objects;

import Game.Objects.Tile.Tile;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

public class Player {
    private int xpos;
    private int ypos;

    private int versuche = 0;
    private ArrayList<Tile> steine;

    public Player() {
        this.steine = new ArrayList<>();
    }

    public void setxpos(int xpos) {
        this.xpos = xpos;
    }

    public void setypos(int ypos) {
        this.ypos = ypos;
    }

    public int getxpos() {
        return xpos;
    }

    public int getypos() {
        return ypos;
    }



    public ArrayList<Tile> getSteine() {
        return steine;
    }

    public void setSteine(ArrayList<Tile> steine) {
        this.steine = steine;
    }

    public int getVersuche() {
        return versuche;
    }

    public void setVersuche(int versuche) {
        this.versuche = versuche;
    }
}
