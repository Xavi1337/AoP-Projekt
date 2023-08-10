package Game.Objects.Tile;
import java.awt.Color;
import java.awt.Graphics2D;

public class StartYellow extends Tile {
    public StartYellow(int x, int y) {
        super(x, y);
    }

    public void render(Graphics2D g, int tileSize) {
        g.setColor(Color.yellow);
        g.fillOval(this.x * tileSize, this.y * tileSize, tileSize - 10, tileSize - 10);
    }
}
