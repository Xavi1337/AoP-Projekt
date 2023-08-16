package Game;

import Game.Objects.Player;
import Game.Objects.Tile.SpielerRot;

class Spielablauf  {

    private Player[] spieler;
    private int spieleranzahl = 4;

    public Spielablauf() {

    }

    public void checkDiceRoll(int diceRoll) {
        if (diceRoll == 6) {
            System.out.println("Glückwunsch! Eine 6 wurde geworfen.");
            spielstart();
        } else {
            System.out.println("Sie haben eine " + diceRoll + " gewürfelt!");
        }
    }

    public void spielstart() {
        GameMap.setTile(0, 4, new SpielerRot(0, 4));
    }
}

