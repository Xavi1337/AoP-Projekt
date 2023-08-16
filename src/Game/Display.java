package Game;

import Game.Objects.Player1;
import Game.Objects.Player2;
import Game.Objects.Player3;
import Game.Objects.Player4;
import java.awt.*;
import javax.swing.*;

public class Display extends JPanel{

    private final GameMap map;
    private final Player1 player1;
    private final Player2 player2;
    private final Player3 player3;
    private final Player4 player4;
    private final Color yellowboard = new Color(204, 204, 0);

    public Display() {

        map = new GameMap(50);
        player1 = new Player1(8.5, 12.5, 0.375);
        player2 = new Player2(7.5, 12.5, 0.375);
        player3 = new Player3(6.5, 12.5, 0.375);
        player4 = new Player4(5.5, 12.5, 0.375);
    }

    public void paint(Graphics g) {
        Graphics2D g2  = (Graphics2D) g;

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        g2.setColor(yellowboard);
        g2.fillRect(0,0, getWidth(), getHeight());

        map.render(g2, map.getTileSize());
        player1.render(g2, map.getTileSize());
        player2.render(g2, map.getTileSize());
        player3.render(g2, map.getTileSize());
        player4.render(g2, map.getTileSize());
    }
}
