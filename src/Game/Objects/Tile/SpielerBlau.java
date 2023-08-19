package Game.Objects.Tile;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SpielerBlau extends Tile implements MouseListener {


    private boolean active = false;
    public SpielerBlau(int x, int y) {
        super(x, y);

    }

    public void render(Graphics2D g, int tileSize) {
        if(isActive()) {
            g.setColor(Color.blue);
            g.fillOval(this.x * tileSize, this.y * tileSize, tileSize - 10, tileSize - 10);
            g.setColor(Color.black);
            g.drawOval(this.x * tileSize, this.y * tileSize, tileSize - 10, tileSize - 10);
        }else{
            g.setColor(Color.blue);
            g.fillOval(this.x * tileSize, this.y * tileSize, tileSize - 10, tileSize - 10);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        setActive(true);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
