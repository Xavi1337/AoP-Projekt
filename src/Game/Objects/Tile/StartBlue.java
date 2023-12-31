package Game.Objects.Tile;
import java.awt.Color;
import java.awt.Graphics2D;

public class StartBlue extends Tile {
    public StartBlue(int x, int y) {
        super(x, y);
    }

    public void render(Graphics2D g, int tileSize) {
        if (getState() == 1) {
            g.setColor(Color.blue);
            g.fillOval(this.x * tileSize, this.y * tileSize, tileSize - 10, tileSize - 10);
        } else {
            g.setColor(Color.white);
            g.fillOval(this.x * tileSize, this.y * tileSize, tileSize - 10, tileSize - 10);
            g.setColor(Color.blue);
            g.drawOval(this.x * tileSize, this.y * tileSize, tileSize - 10, tileSize - 10);
        }
    }

}