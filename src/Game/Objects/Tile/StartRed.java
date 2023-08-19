package Game.Objects.Tile;
import java.awt.Color;
import java.awt.Graphics2D;

public class StartRed extends Tile {
    public StartRed(int x, int y) {
        super(x, y);
    }

    public void render(Graphics2D g, int tileSize) {
        if (getState() == 1) {
            g.setColor(Color.red);
            g.fillOval(this.x * tileSize, this.y * tileSize, tileSize - 10, tileSize - 10);
        } else {
            g.setColor(Color.white);
            g.fillOval(this.x * tileSize, this.y * tileSize, tileSize - 10, tileSize - 10);
            g.setColor(Color.red);
            g.drawOval(this.x * tileSize, this.y * tileSize, tileSize - 10, tileSize - 10);
        }
    }
}
