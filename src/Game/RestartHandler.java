package Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

class RestartHandler implements ActionListener {
    private final Game game;

    public RestartHandler(Game game) {
        this.game = game;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /* dispose(); */
        new AbfrageFenster();
    }
}