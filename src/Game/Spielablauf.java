package Game;
import Game.Objects.Tile.SpielerRot;


class Spielablauf {





    public void checkDiceRoll(int diceRoll) {
        if (diceRoll == 6) {
            System.out.println("Glückwunsch! Eine 6 wurde geworfen. Das Spiel beginnt.");
            spielstart();
        } else {
            System.out.println("Sie haben eine " + diceRoll + " gewürfelt!");
        }
    }

    public void spielstart() {

        /*gameMap.setTile(4, 0, new SpielerRot(4, 0));*/
    }
}
