package Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import Game.Game;

class DiceRollHandler implements ActionListener {
    int lastDiceRoll = 0;
    @Override
    public void actionPerformed(ActionEvent e) {
        lastDiceRoll = rollDice();
        System.out.println("Geworfen: " + lastDiceRoll);
        Spielablauf spielablauf = new Spielablauf();
        spielablauf.checkDiceRoll(lastDiceRoll);

    }
    public int rollDice() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }

}