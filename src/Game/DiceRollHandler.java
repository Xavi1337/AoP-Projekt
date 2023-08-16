package Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

class DiceRollHandler implements ActionListener {
    int lastDiceRoll = 0;
    Display display;
    Spielablauf spielablauf = new Spielablauf();

    public DiceRollHandler(Display display) {
        this.display = display;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        lastDiceRoll = rollDice();
        System.out.println("Geworfen: " + lastDiceRoll);
        spielablauf.checkDiceRoll(lastDiceRoll);
        display.repaint();
    }

    public int rollDice() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }

}