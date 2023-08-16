package Game.Objects.Tile;

import java.awt.*;

public class SpielerGelb extends Tile {
    public SpielerGelb(int x, int y) { super(x, y); }

    public void render(Graphics2D g, int tileSize) {
        g.setColor(Color.yellow);
        g.fillOval(this.x * tileSize, this.y * tileSize, tileSize - 10, tileSize - 10);
        g.setColor(Color.black);
        g.drawOval(this.x * tileSize, this.y * tileSize, tileSize - 10, tileSize - 10);
    }
}
