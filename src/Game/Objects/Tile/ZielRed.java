package Game.Objects.Tile;

import java.awt.*;

public class ZielRed extends Tile {
    public ZielRed(int x, int y) {
        super(x, y);
    }

    public void render(Graphics2D g, int tileSize) {
        g.setColor(Color.white);
        g.fillOval(this.x * tileSize, this.y * tileSize, tileSize - 10, tileSize - 10);
        g.setColor(Color.red);
        g.drawOval(this.x * tileSize, this.y * tileSize, tileSize - 10, tileSize - 10);
    }
}
