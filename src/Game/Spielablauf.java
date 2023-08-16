package Game;

import Game.Objects.*;
import Game.Objects.Tile.*;

class Spielablauf  {
    private int runde = 0;
    private GameMap map;
    private Player[] spielers = new Player[4];
    private int spieleranzahl = 4;

    public Spielablauf(GameMap map) {
        this.map = map;
        for (int i = 0; i < spieleranzahl; i++) {

            if (i == 0) {
                Integer[][] wegGruen = {{4, 0}, {4, 1}, {4, 2}, {4, 3}, {4, 4},
                                        {3, 4}, {2, 4}, {1, 4}, {0, 4},
                                        {0, 5}, {0, 6},
                                        {1, 6}, {2, 6}, {3, 6}, {4, 6},
                                        {4, 7}, {4, 8}, {4, 9}, {4, 10},
                                        {5, 10}, {6, 10},
                                        {6, 9}, {6, 8}, {6, 7}, {6, 6},
                                        {7, 6}, {8, 6}, {9, 6}, {10, 6},
                                        {10, 5}, {10, 4},
                                        {9, 4}, {8, 4}, {7, 4}, {6, 4},
                                        {6, 3}, {6, 2}, {6, 1}, {6, 0},
                                        {5, 0}};
                spielers[i] = new Player(wegGruen);
            } else if (i == 1) {
                Integer[][] wegGruen = {{4, 0}, {4, 1}, {4, 2}, {4, 3}, {4, 4},
                                        {3, 4}, {2, 4}, {1, 4}, {0, 4},
                                        {0, 5}, {0, 6},
                                        {1, 6}, {2, 6}, {3, 6}, {4, 6},
                                        {4, 7}, {4, 8}, {4, 9}, {4, 10},
                                        {5, 10}, {6, 10},
                                        {6, 9}, {6, 8}, {6, 7}, {6, 6},
                                        {7, 6}, {8, 6}, {9, 6}, {10, 6},
                                        {10, 5}, {10, 4},
                                        {9, 4}, {8, 4}, {7, 4}, {6, 4},
                                        {6, 3}, {6, 2}, {6, 1}, {6, 0},
                                        {5, 0}};
                spielers[i] = new Player(wegGruen);
                //Repeat
            } else if (i == 2) {
                Integer[][] wegGruen = {{4, 0}, {4, 1}, {4, 2}, {4, 3}, {4, 4},
                                        {3, 4}, {2, 4}, {1, 4}, {0, 4},
                                        {0, 5}, {0, 6},
                                        {1, 6}, {2, 6}, {3, 6}, {4, 6},
                                        {4, 7}, {4, 8}, {4, 9}, {4, 10},
                                        {5, 10}, {6, 10},
                                        {6, 9}, {6, 8}, {6, 7}, {6, 6},
                                        {7, 6}, {8, 6}, {9, 6}, {10, 6},
                                        {10, 5}, {10, 4},
                                        {9, 4}, {8, 4}, {7, 4}, {6, 4},
                                        {6, 3}, {6, 2}, {6, 1}, {6, 0},
                                        {5, 0}};
                spielers[i] = new Player(wegGruen);
                //Repeat
            } else if (i == 3) {
                Integer[][] wegGruen = {{4, 0}, {4, 1}, {4, 2}, {4, 3}, {4, 4},
                                        {3, 4}, {2, 4}, {1, 4}, {0, 4},
                                        {0, 5}, {0, 6},
                                        {1, 6}, {2, 6}, {3, 6}, {4, 6},
                                        {4, 7}, {4, 8}, {4, 9}, {4, 10},
                                        {5, 10}, {6, 10},
                                        {6, 9}, {6, 8}, {6, 7}, {6, 6},
                                        {7, 6}, {8, 6}, {9, 6}, {10, 6},
                                        {10, 5}, {10, 4},
                                        {9, 4}, {8, 4}, {7, 4}, {6, 4},
                                        {6, 3}, {6, 2}, {6, 1}, {6, 0},
                                        {5, 0}};
                spielers[i] = new Player(wegGruen);
                //Repeat
            }
        }
    }

    public void checkDiceRoll(int diceRoll) {
        if (spielers[runde % 4].getSteine().isEmpty()) {
            if (spielers[runde % 4].getVersuche() < 3) {
                if (diceRoll == 6) {
                    System.out.println("Glückwunsch! Eine 6 wurde geworfen.");
                    spielers[runde % 4].setVersuche(0);
                    spielstart();
                } else {
                    System.out.println("Sie haben eine " + diceRoll + " gewürfelt!");
                    spielers[runde % 4].setVersuche(spielers[runde % 4].getVersuche() + 1);
                }
            } else {
                System.out.println("Der nächste Spieler ist an der Reihe.");
                spielers[runde % 4].setVersuche(0);
                runde++;
            }
        } else if (!(map.getTile(spielers[runde%4].getxpos(), spielers[runde%4].getypos()) instanceof Field) && spielers[runde % 4].getVersuche() == 0) {
            System.out.println("Hallo");
            for (int i = 0; i < spielers[runde%4].getSteine().size(); i++) {
                if (map.getTile(spielers[runde%4].getxpos(), spielers[runde%4].getypos()) == spielers[runde%4].getSteine().get(i)) {
                    if (diceRoll == 6) {
                        System.out.println("Glückwunsch! Eine 6 wurde geworfen.");
                        spielzugStart(diceRoll);
                    } else {
                        System.out.println("Sie haben eine " + diceRoll + " gewürfelt!");
                        spielzug(diceRoll);
                        spielers[runde % 4].setVersuche(spielers[runde % 4].getVersuche() + 1);
                    }
                } else {
                    //Hier ist das Startfeld blockiert
                    System.out.println(map.getTile(spielers[runde%4].getxpos(), spielers[runde%4].getypos()) + " steht auf dem Feld!");
                }
            }
        } else if (map.getTile(spielers[runde%4].getxpos(), spielers[runde%4].getypos()) instanceof Field && spielers[runde % 4].getVersuche() == 0) {
            if (diceRoll == 6) {
                System.out.println("Glückwunsch! Eine 6 wurde geworfen.");
                if (spielers[runde % 4].getSteine().size() < 4) {
                    spielzugStart(diceRoll);
                } else {
                    spielzug(diceRoll);
                }
            } else {
                System.out.println("Sie haben eine " + diceRoll + " gewürfelt!");
                spielzug(diceRoll);
                spielers[runde % 4].setVersuche(spielers[runde % 4].getVersuche() + 1);
            }
        } else {
            System.out.println("Der nächste Spieler ist an der Reihe.");
            spielers[runde % 4].setVersuche(0);
            runde++;
        }
    }

    public void spielzugStart(int diceRoll) {

    }

    public void spielzug(int diceRoll) {
        System.out.println(spielers[runde%4].getSteine());
        int newPos = spielers[runde%4].getSteine().get(0).getPos() + diceRoll;
        Tile spielerGruen = new SpielerGruen(spielers[runde%4].getWeg()[newPos][0], spielers[runde%4].getWeg()[newPos][1]);
        spielerGruen.setPos(newPos);
        spielers[runde%4].getSteine().remove(0);
        spielers[runde%4].getSteine().add(0, spielerGruen);
        map.setTile(spielerGruen);
    }

    public void spielstart() {
        switch(runde%4) {
            case 0:
                Tile spielerGruen = new SpielerGruen(spielers[runde%4].getypos(), spielers[runde%4].getxpos());
                spielerGruen.setPos(0);
                spielers[runde%4].getSteine().add(spielerGruen);
                map.setTile(spielerGruen);
                break;
            case 1:
                Tile spielerGelb = new SpielerGelb(spielers[runde%4].getypos(), spielers[runde%4].getxpos());
                spielerGelb.setPos(0);
                spielers[runde%4].getSteine().add(spielerGelb);
                map.setTile(spielerGelb);
                break;
            case 2:
                Tile spielerBlau = new SpielerBlau(spielers[runde%4].getypos(), spielers[runde%4].getxpos());
                spielerBlau.setPos(0);
                spielers[runde%4].getSteine().add(spielerBlau);
                map.setTile(spielerBlau);
                break;
            case 3:
                Tile spielerRot = new SpielerRot(spielers[runde%4].getypos(), spielers[runde%4].getxpos());
                spielerRot.setPos(0);
                spielers[runde%4].getSteine().add(spielerRot);
                map.setTile(spielerRot);
                break;
        }


    }
}

/* startposition grün: x 4, y 0
   startposition gelb: x 0, y 6
   startposition blau: x 6, y 10
   startposition rot:  x 10, y 4
 */