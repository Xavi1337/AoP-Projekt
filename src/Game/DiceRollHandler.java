package Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

class DiceRollHandler implements ActionListener {
    int lastDiceRoll = 0;
    int teilnehmer;
    Display display;
    Spielablauf spielablauf;

    public DiceRollHandler(Display display, int teilnehmer) {

        this.display = display;
        this.spielablauf = new Spielablauf(display);
        this.teilnehmer = teilnehmer;
    }

    @Override
    public void actionPerformed(ActionEvent e) {


        if (spielablauf.getRunde()%4 >= teilnehmer) {
            while (spielablauf.getRunde() % 4 >= teilnehmer) {
                lastDiceRoll = rollDice();
                spielablauf.checkDiceRollKI(lastDiceRoll);
            }
        } else {
            lastDiceRoll = rollDice();
            spielablauf.checkDiceRoll(lastDiceRoll);
        }

        SoundManager soundManager = new SoundManager();
        soundManager.loadSound("dice_roll.wav");
        soundManager.playSound();
        display.validate();
        display.repaint();
    }

    public int rollDice() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }

}