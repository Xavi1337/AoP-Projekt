package Game.Objects.Tile;

import java.awt.Color;
import java.awt.Graphics2D;


public class Field extends Tile {
    public Field(int x, int y) {
        super(x, y);
    }

    public void render(Graphics2D g, int tileSize) {
        g.setColor(Color.white);
        g.fillOval(this.x * tileSize, this.y * tileSize, tileSize - 10, tileSize - 10);
    }
}