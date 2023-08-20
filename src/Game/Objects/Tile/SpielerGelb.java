package Game.Objects.Tile;

import java.awt.*;

public class SpielerGelb extends Tile {
    private int index;
    public SpielerGelb(int x, int y, int index) {

        super(x, y);
        this.index = index;
    }



    public void render(Graphics2D g, int tileSize) {
        g.setColor(Color.yellow);
        g.fillOval(this.x * tileSize, this.y * tileSize, tileSize - 10, tileSize - 10);
        g.setColor(Color.black);
        g.drawOval(this.x * tileSize, this.y * tileSize, tileSize - 10, tileSize - 10);

        switch (index) {
            case 0:
                g.setColor(Color.black);
                g.fillOval(this.x * tileSize + 10, this.y * tileSize + 10, tileSize - 30, tileSize - 30);
                break;
            case 1:
                g.setColor(Color.gray);
                g.fillOval(this.x * tileSize + 10, this.y * tileSize + 10, tileSize - 30, tileSize - 30);
                break;
            case 2:
                g.setColor(Color.lightGray);
                g.fillOval(this.x * tileSize + 10, this.y * tileSize + 10, tileSize - 30, tileSize - 30);
                break;
            case 3:
                g.setColor(Color.white);
                g.fillOval(this.x * tileSize + 10, this.y * tileSize + 10, tileSize - 30, tileSize - 30);
                break;
        }
    }
}
