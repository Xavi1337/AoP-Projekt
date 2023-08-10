package Game.Objects.Tile;
import java.awt.*;

public class Air extends Tile {

    public Air(int x, int y) {
        super(x, y);
    }

    @Override
    public void render(Graphics2D g, int tileSize) {
        // Luft ist unsichtbar
    }
}
