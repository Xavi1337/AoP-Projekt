package Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

class DiceRollHandler implements ActionListener {
    int lastDiceRoll = 0;
    Display display;
    Spielablauf spielablauf;

    public DiceRollHandler(Display display) {

        this.display = display;
        this.spielablauf = new Spielablauf(display.getMap());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        lastDiceRoll = rollDice();
        spielablauf.checkDiceRoll(lastDiceRoll);
        display.repaint();
    }

    public int rollDice() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }

}