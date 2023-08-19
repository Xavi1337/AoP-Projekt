package Game;

import Game.Objects.*;
import Game.Objects.Tile.*;

import java.util.Arrays;

class Spielablauf  {
    private int runde = 0;
    private GameMap map;
    private Player[] spielers = new Player[4];
    private int spieleranzahl = 4;

    public Spielablauf(GameMap map) {
        this.map = map;
        for (int i = 0; i < spieleranzahl; i++) {
            if (i == 0) {

                //Grün Gelb Blau Rot
                Integer[][] weg =      {{0, 4}, //Start Gruen
                                        {1, 4}, {2, 4}, {3, 4},
                                        {4, 4},
                                        {4, 3}, {4, 2}, {4, 1},
                                        {4, 0},
                                        {5, 0},

                                        {6, 0}, //Start Gelb
                                        {6, 1}, {6, 2}, {6, 3},
                                        {6, 4},
                                        {7, 4}, {8, 4}, {9, 4},
                                        {10, 4},
                                        {10, 5},

                                        {10, 6}, //Start Blau
                                        {9, 6}, {8, 6}, {7, 6},
                                        {6, 6},
                                        {6, 7}, {6, 8}, {6, 9},
                                        {6, 10},
                                        {5, 10},

                                        {4, 10}, //Start Rot
                                        {4, 9}, {4, 8}, {4, 7},
                                        {4, 6},
                                        {3, 6}, {2, 6}, {1, 6},
                                        {0, 6},
                                        {0, 5},

                                        {1, 5}, {2, 5}, {3, 5}, {4, 5}}; //Ziel Gruen
                spielers[i] = new Player(weg);
            } else if (i == 1) {
                Integer[][] weg =      {{6, 0}, //Start Gelb
                                        {6, 1}, {6, 2}, {6, 3},
                                        {6, 4},
                                        {7, 4}, {8, 4}, {9, 4},
                                        {10, 4},
                                        {10, 5},

                                        {10, 6}, //Start Blau
                                        {9, 6}, {8, 6}, {7, 6},
                                        {6, 6},
                                        {6, 7}, {6, 8}, {6, 9},
                                        {6, 10},
                                        {5, 10},

                                        {4, 10}, //Start Rot
                                        {4, 9}, {4, 8}, {4, 7},
                                        {4, 6},
                                        {3, 6}, {2, 6}, {1, 6},
                                        {0, 6},
                                        {0, 5},

                                        {0, 4}, //Start Gruen
                                        {1, 4}, {2, 4}, {3, 4},
                                        {4, 4},
                                        {4, 3}, {4, 2}, {4, 1},
                                        {4, 0},
                                        {5, 0},

                                        {5, 1}, {5, 2}, {5, 3}, {5, 4}}; //Ziel Gelb
                spielers[i] = new Player(weg);
            } else if (i == 2) {
                Integer[][] weg =      {{10, 6}, //Start Blau
                                        {9, 6}, {8, 6}, {7, 6},
                                        {6, 6},
                                        {6, 7}, {6, 8}, {6, 9},
                                        {6, 10},
                                        {5, 10},

                                        {4, 10}, //Start Rot
                                        {4, 9}, {4, 8}, {4, 7},
                                        {4, 6},
                                        {3, 6}, {2, 6}, {1, 6},
                                        {0, 6},
                                        {0, 5},

                                        {0, 4}, //Start Gruen
                                        {1, 4}, {2, 4}, {3, 4},
                                        {4, 4},
                                        {4, 3}, {4, 2}, {4, 1},
                                        {4, 0},
                                        {5, 0},

                                        {6, 0}, //Start Gelb
                                        {6, 1}, {6, 2}, {6, 3},
                                        {6, 4},
                                        {7, 4}, {8, 4}, {9, 4},
                                        {10, 4},
                                        {10, 5},

                                        {9, 5}, {8, 5}, {7, 5}, {6, 5}}; //Ziel Blau

                spielers[i] = new Player(weg);
            } else {
                Integer[][] weg =      {{4, 10}, //Start Rot
                                        {4, 9}, {4, 8}, {4, 7},
                                        {4, 6},
                                        {3, 6}, {2, 6}, {1, 6},
                                        {0, 6},
                                        {0, 5},

                                        {0, 4}, //Start Gruen
                                        {1, 4}, {2, 4}, {3, 4},
                                        {4, 4},
                                        {4, 3}, {4, 2}, {4, 1},
                                        {4, 0},
                                        {5, 0},

                                        {6, 0}, //Start Gelb
                                        {6, 1}, {6, 2}, {6, 3},
                                        {6, 4},
                                        {7, 4}, {8, 4}, {9, 4},
                                        {10, 4},
                                        {10, 5},

                                        {10, 6}, //Start Blau
                                        {9, 6}, {8, 6}, {7, 6},
                                        {6, 6},
                                        {6, 7}, {6, 8}, {6, 9},
                                        {6, 10},
                                        {5, 10},

                                        {5, 9}, {5, 8}, {5, 7}, {5, 6}}; //Ziel Rot
                spielers[i] = new Player(weg);
            }
        }
    }

    public void checkDiceRoll(int diceRoll) {
        if (spielers[runde % 4].getSteine().isEmpty()) {
            if (spielers[runde % 4].getVersuche() < 3) {
                if (diceRoll == 6) {
                    System.out.println("Glückwunsch! Eine 6 wurde geworfen.");
                    System.out.println("Keine Spielsteine auf dem Feld.");
                    spielers[runde % 4].setVersuche(0);
                    spielzugStart(diceRoll);
                } else {
                    System.out.println("Sie haben eine " + diceRoll + " gewürfelt!");
                    System.out.println("Keine Spielsteine auf dem Feld.");
                    spielers[runde % 4].setVersuche(spielers[runde % 4].getVersuche() + 1);
                }
            } else {
                System.out.println("Der nächste Spieler ist an der Reihe.");
                spielers[runde % 4].setVersuche(0);
                runde++;
            }
        } else if (spielers[runde % 4].getSteine().size() < 4) {
            System.out.println("1-3 Steine auf dem Spielfeld");
            if (diceRoll == 6) {
                System.out.println("Glückwunsch! Eine 6 wurde geworfen.");
                spielzugStart(diceRoll);
            } else {
                System.out.println("Sie haben eine " + diceRoll + " gewürfelt!");
                spielzug(diceRoll);
                runde++;
                //spielers[runde % 4].setVersuche(spielers[runde % 4].getVersuche() + 1);
            }
        } else if (spielers[runde % 4].getSteine().size() == 4) {
            System.out.println("Alle Steine auf dem Spielfeld");
            if (diceRoll == 6) {
                System.out.println("Glückwunsch! Eine 6 wurde geworfen.");
                spielzug(diceRoll);
            } else {
                System.out.println("Sie haben eine " + diceRoll + " gewürfelt!");
                spielzug(diceRoll);
                runde++;
                //spielers[runde % 4].setVersuche(spielers[runde % 4].getVersuche() + 1);
            }
        }
    }

    public void startfeldTest() {
        for (int i = 0; i < map.getTiles().length; i++) {
            for (int j = 0; j < map.getTiles()[i].length; j++) {
                switch (runde % 4) {
                    case 0:
                        if (map.getTiles()[i][j] instanceof StartGreen) {
                            int posX = map.getTiles()[i][j].getX();
                            int posY = map.getTiles()[i][j].getY();
                            Tile field = new Field(posX, posY);
                            map.setTile(field);
                            return;
                        }
                        break;
                    case 1:
                        if (map.getTiles()[i][j] instanceof StartYellow) {
                            int posX = map.getTiles()[i][j].getX();
                            int posY = map.getTiles()[i][j].getY();
                            Tile field = new Field(posX, posY);
                            map.setTile(field);
                            return;
                        }
                        break;
                    case 2:
                        if (map.getTiles()[i][j] instanceof StartBlue) {
                            int posX = map.getTiles()[i][j].getX();
                            int posY = map.getTiles()[i][j].getY();
                            Tile field = new Field(posX, posY);
                            map.setTile(field);
                            return;
                        }
                        break;
                    case 3:
                        if (map.getTiles()[i][j] instanceof StartRed) {
                            int posX = map.getTiles()[i][j].getX();
                            int posY = map.getTiles()[i][j].getY();
                            Tile field = new Field(posX, posY);
                            map.setTile(field);
                            return;
                        }
                        break;
                }
            }
        }
    }

    public void spielzugStart(int diceRoll) {
        //nach gewürfelter 6, Stein muss bewegt werden
        startfeldTest();


        System.out.println(Arrays.deepToString(map.getTiles()));

        Tile field = new Field(spielers[runde%4].getWeg()[0][0], spielers[runde%4].getWeg()[0][1]);
        map.setTile(field);


        switch(runde%4) {
            case 0:
                Tile spielerGruen = new SpielerGruen(spielers[runde%4].getxpos(), spielers[runde%4].getypos());
                spielerGruen.setPos(0);
                spielers[runde%4].getSteine().add(spielerGruen);
                map.setTile(spielerGruen);
                break;
            case 1:
                Tile spielerGelb = new SpielerGelb(spielers[runde%4].getxpos(), spielers[runde%4].getypos());
                spielerGelb.setPos(0);
                spielers[runde%4].getSteine().add(spielerGelb);
                map.setTile(spielerGelb);
                break;
            case 2:
                Tile spielerBlau = new SpielerBlau(spielers[runde%4].getxpos(), spielers[runde%4].getypos());
                spielerBlau.setPos(0);
                spielers[runde%4].getSteine().add(spielerBlau);
                map.setTile(spielerBlau);
                break;
            case 3:
                Tile spielerRot = new SpielerRot(spielers[runde%4].getxpos(), spielers[runde%4].getypos());
                spielerRot.setPos(0);
                spielers[runde%4].getSteine().add(spielerRot);
                map.setTile(spielerRot);
                break;
        }
    }


    public void spielzug(int diceRoll) {
        //Stein kann frei ausgewählt werden
        int pos = spielers[runde%4].getSteine().get(0).getPos();
        Tile field = new Field(spielers[runde%4].getWeg()[pos][0], spielers[runde%4].getWeg()[pos][1]);
        map.setTile(field);
        int newPos = pos + diceRoll;
        switch (runde % 4) {
            case 0:
                Tile spielerGruen = new SpielerGruen(spielers[runde%4].getWeg()[newPos][0], spielers[runde%4].getWeg()[newPos][1]);
                spielerGruen.setPos(newPos);
                spielers[runde%4].getSteine().remove(0);
                spielers[runde%4].getSteine().add(0, spielerGruen);
                map.setTile(spielerGruen);
                break;
            case 1:
                Tile spielerGelb = new SpielerGelb(spielers[runde%4].getWeg()[newPos][0], spielers[runde%4].getWeg()[newPos][1]);
                System.out.println(Arrays.toString(spielers[runde % 4].getWeg()[newPos]));
                spielerGelb.setPos(newPos);
                spielers[runde%4].getSteine().remove(0);
                spielers[runde%4].getSteine().add(0, spielerGelb);
                map.setTile(spielerGelb);
                break;
            case 2:
                Tile spielerBlau = new SpielerBlau(spielers[runde%4].getWeg()[newPos][0], spielers[runde%4].getWeg()[newPos][1]);
                spielerBlau.setPos(newPos);
                spielers[runde%4].getSteine().remove(0);
                spielers[runde%4].getSteine().add(0, spielerBlau);
                map.setTile(spielerBlau);
                break;
            case 3:
                Tile spielerRot = new SpielerRot(spielers[runde%4].getWeg()[newPos][0], spielers[runde%4].getWeg()[newPos][1]);
                spielerRot.setPos(newPos);
                spielers[runde%4].getSteine().remove(0);
                spielers[runde%4].getSteine().add(0, spielerRot);
                map.setTile(spielerRot);
                break;
        }
    }

}