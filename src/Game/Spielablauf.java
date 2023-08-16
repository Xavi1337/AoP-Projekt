package Game;

import Game.Objects.Player;
import Game.Objects.Tile.SpielerRot;
import Game.Objects.Tile.Field;
import Game.Objects.Tile.Tile;

class Spielablauf  {
    private int runde = 0;

    private GameMap map;
    private Player[] spielers = new Player[4];
    private int spieleranzahl = 4;

    public Spielablauf(GameMap map) {
        this.map = map;
        for (int i = 0; i < spieleranzahl; i++) {
            spielers[i] = new Player();
            if (i == 0) {
                spielers[i].setxpos(4);
                spielers[i].setypos(0);
            } else if (i == 1) {
                spielers[i].setxpos(0);
                spielers[i].setypos(6);
            } else if (i == 2) {
                spielers[i].setxpos(6);
                spielers[i].setypos(10);
            } else if (i == 3) {
                spielers[i].setxpos(10);
                spielers[i].setypos(4);
            }
        }

    }

    public void checkDiceRoll(int diceRoll) {
        //System.out.println(spieler[runde % 4].getSteine().isEmpty());
        if (spielers[runde % 4].getSteine().isEmpty()) {
            if (spielers[runde % 4].getVersuche() < 3) {
                System.out.println(runde % 4);
                if (diceRoll == 6) {
                    System.out.println("Glückwunsch! Eine 6 wurde geworfen.");
                    spielstart();
                } else {
                    System.out.println("Sie haben eine " + diceRoll + " gewürfelt!");
                }
                spielers[runde % 4].setVersuche(spielers[runde % 4].getVersuche() +1);
            } else {
                spielers[runde % 4].setVersuche(0);
                runde++;

            }
        } else if (map.getTile(spielers[runde%4].getxpos(), spielers[runde%4].getypos()) instanceof Field) {

        }

    }

    public void spielstart() {

        //System.out.println(map.getTile(4,0));
        Tile spieler = new SpielerRot(spielers[runde%4].getypos(), spielers[runde%4].getxpos());
        map.setTile(spieler);
    }
}

/* startposition grün: x 4, y 0
   startposition gelb: x 0, y 6
   startposition blau: x 6, y 10
   startposition rot:  x 10, y 4
 */