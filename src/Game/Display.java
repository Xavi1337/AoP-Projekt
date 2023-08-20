package Game;

import java.awt.*;
import javax.swing.*;

public class Display extends JPanel{

    public GameMap getMap() {
        return map;
    }

    private final GameMap map;


    private final Color yellowboard = new Color(254, 241, 126);

    public Display() {

        map = new GameMap(48);
    }

    public void paint(Graphics g) {
        Graphics2D g2  = (Graphics2D) g;

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        g2.setColor(yellowboard);
        g2.fillRect(0,0, getWidth(), getHeight());

        map.render(g2, map.getTileSize());
    }

}
