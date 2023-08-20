package Game;

import Game.Objects.*;
import Game.Objects.Tile.*;

import javax.swing.*;
import java.util.Arrays;
import java.util.Objects;

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
                    System.out.println("Glückwunsch! Spieler " + runde % 4 + " hat eine 6 wurde geworfen.");
                    System.out.println("Keine Spielsteine auf dem Feld.");
                    spielers[runde % 4].setVersuche(0);
                    spielzugStart(diceRoll);
                } else {
                    System.out.println("Spieler " + runde % 4 + " hat eine " + diceRoll + " gewürfelt!");
                    System.out.println("Keine Spielsteine auf dem Feld.");
                    spielers[runde % 4].setVersuche(spielers[runde % 4].getVersuche() + 1);
                }
            } else {

                //zeigeSpielerPopup(String.valueOf(spielers[runde % 4]));
                spielers[runde % 4].setVersuche(0);
                runde++;
            }
        } else if (spielers[runde % 4].getSteine().size() < 4) {
            System.out.println("Spieler " + runde % 4 + " hat 1-3 Steine auf dem Spielfeld");
            if (diceRoll == 6) {
                System.out.println("Glückwunsch! Spieler " + runde % 4 + " hat eine 6 wurde geworfen.");
                spielzugStart(diceRoll);
            } else {
                System.out.println("Spieler " + runde % 4 + " hat eine " + diceRoll + " gewürfelt!");
                spielzug(diceRoll, 0);
                runde++;
            }
        } else if (spielers[runde % 4].getSteine().size() == 4) {
            System.out.println("Spieler " + runde % 4 + " hat alle Steine auf dem Spielfeld");
            if (diceRoll == 6) {
                System.out.println("Glückwunsch! Spieler " + runde % 4 + " hat eine 6 wurde geworfen.");
                spielzug(diceRoll, 0);
            } else {
                System.out.println("Spieler " + runde % 4 + " hat eine " + diceRoll + " gewürfelt!");
                spielzug(diceRoll, 0);
                runde++;
            }
        }
    }

    public static void zeigeSpielerPopup(String spielerName) {
        JFrame frame = new JFrame("Spielerwechsel");
        JOptionPane.showMessageDialog(frame, "Nächster Spieler: " + spielerName, "Spielerwechsel", JOptionPane.INFORMATION_MESSAGE);
        frame.dispose();
    }

    public void startfeldleeren() {
        for (int i = 0; i < map.getTiles().length; i++) {
            for (int j = 0; j < map.getTiles()[i].length; j++) {
                switch (runde % 4) {
                    case 0:
                        if (map.getTiles()[i][j] instanceof StartGreen && map.getTiles()[i][j].getState() == 1) {
                            map.getTiles()[i][j].setState(0);
                            return;
                        }
                        break;
                    case 1:
                        if (map.getTiles()[i][j] instanceof StartYellow && map.getTiles()[i][j].getState() == 1) {
                            map.getTiles()[i][j].setState(0);
                            return;
                        }
                        break;
                    case 2:
                        if (map.getTiles()[i][j] instanceof StartBlue && map.getTiles()[i][j].getState() == 1) {
                            map.getTiles()[i][j].setState(0);
                            return;
                        }
                        break;
                    case 3:
                        if (map.getTiles()[i][j] instanceof StartRed && map.getTiles()[i][j].getState() == 1) {
                            map.getTiles()[i][j].setState(0);
                            return;
                        }
                        break;
                }
            }
        }
    }

    public void startfeldfuellen(int spieler) {
        for (int i = 0; i < map.getTiles().length; i++) {
            for (int j = 0; j < map.getTiles()[i].length; j++) {
                switch (spieler) {
                    case 0:
                        if (map.getTiles()[i][j] instanceof StartGreen && map.getTiles()[i][j].getState() == 0) {
                            map.getTiles()[i][j].setState(1);
                            return;
                        }
                        break;
                    case 1:
                        if (map.getTiles()[i][j] instanceof StartYellow && map.getTiles()[i][j].getState() == 0) {
                            map.getTiles()[i][j].setState(1);
                            return;
                        }
                        break;
                    case 2:
                        if (map.getTiles()[i][j] instanceof StartBlue && map.getTiles()[i][j].getState() == 0) {
                            map.getTiles()[i][j].setState(1);
                            return;
                        }
                        break;
                    case 3:
                        if (map.getTiles()[i][j] instanceof StartRed && map.getTiles()[i][j].getState() == 0) {
                            map.getTiles()[i][j].setState(1);
                            return;
                        }
                        break;
                }
            }
        }
    }

    public void spielzugStart(int diceRoll) {
        //nach gewürfelter 6, Stein muss bewegt werden
        switch(runde%4) {
            case 0:
                if (zielfeldTest(0)) {
                    startfeldleeren();
                    Tile spielerGruen = new SpielerGruen(spielers[runde % 4].getxpos(), spielers[runde % 4].getypos());
                    spielerGruen.setPos(0);
                    spielers[runde % 4].getSteine().add(spielerGruen);
                    map.setTile(spielerGruen);
                } else {
                    Tile field = new Field(spielers[runde%4].getWeg()[0][0], spielers[runde%4].getWeg()[0][1]);
                    Tile spielStein = spielers[runde % 4].getSteine().get(spielers[runde % 4].getSteine().size()-1);
                    spielStein.setX(spielers[runde%4].getWeg()[diceRoll][0]);
                    spielStein.setY(spielers[runde%4].getWeg()[diceRoll][1]);
                    spielStein.setPos(diceRoll);
                    map.setTile(field);
                    map.setTile(spielStein);
                }
                break;

            case 1:
                if (zielfeldTest(0)) {
                    startfeldleeren();
                    Tile spielerGelb = new SpielerGelb(spielers[runde % 4].getxpos(), spielers[runde % 4].getypos());
                    spielerGelb.setPos(0);
                    spielers[runde % 4].getSteine().add(spielerGelb);
                    map.setTile(spielerGelb);
                } else {
                    Tile field = new Field(spielers[runde%4].getWeg()[0][0], spielers[runde%4].getWeg()[0][1]);
                    Tile spielStein = spielers[runde % 4].getSteine().get(spielers[runde % 4].getSteine().size()-1);
                    spielStein.setX(spielers[runde%4].getWeg()[diceRoll][0]);
                    spielStein.setY(spielers[runde%4].getWeg()[diceRoll][1]);
                    spielStein.setPos(diceRoll);
                    map.setTile(field);
                    map.setTile(spielStein);
                }
                break;
            case 2:
                if (zielfeldTest(0)) {
                    startfeldleeren();
                    Tile spielerBlau = new SpielerBlau(spielers[runde % 4].getxpos(), spielers[runde % 4].getypos());
                    spielerBlau.setPos(0);
                    spielers[runde % 4].getSteine().add(spielerBlau);
                    map.setTile(spielerBlau);
                } else {
                    Tile field = new Field(spielers[runde%4].getWeg()[0][0], spielers[runde%4].getWeg()[0][1]);
                    Tile spielStein = spielers[runde % 4].getSteine().get(spielers[runde % 4].getSteine().size()-1);
                    spielStein.setX(spielers[runde%4].getWeg()[diceRoll][0]);
                    spielStein.setY(spielers[runde%4].getWeg()[diceRoll][1]);
                    spielStein.setPos(diceRoll);
                    map.setTile(field);
                    map.setTile(spielStein);
                }
                break;
            case 3:
                if (zielfeldTest(0)) {
                    startfeldleeren();
                    Tile spielerRot = new SpielerRot(spielers[runde % 4].getxpos(), spielers[runde % 4].getypos());
                    spielerRot.setPos(0);
                    spielers[runde % 4].getSteine().add(spielerRot);
                    map.setTile(spielerRot);
                } else {
                    Tile field = new Field(spielers[runde%4].getWeg()[0][0], spielers[runde%4].getWeg()[0][1]);
                    Tile spielStein = spielers[runde % 4].getSteine().get(spielers[runde % 4].getSteine().size()-1);
                    spielStein.setX(spielers[runde%4].getWeg()[diceRoll][0]);
                    spielStein.setY(spielers[runde%4].getWeg()[diceRoll][1]);
                    spielStein.setPos(diceRoll);
                    map.setTile(field);
                    map.setTile(spielStein);
                }
                break;
        }
    }

    private boolean zielfeldTest(int newpos) {
        if (!(map.getTile(spielers[runde%4].getWeg()[newpos][0], spielers[runde%4].getWeg()[newpos][1]) instanceof Field)) {
            if (map.getTile(spielers[runde%4].getWeg()[newpos][0], spielers[runde%4].getWeg()[newpos][1]) instanceof SpielerGruen) {
                if (runde%4 == 0) {
                    return false;
                } else {
                    for (int i = 0 ; i < spielers[0].getSteine().size(); i++) {
                        if (Objects.equals(spielers[runde % 4].getWeg()[newpos][0], spielers[0].getWeg()[spielers[0].getSteine().get(i).getPos()][0]) &&
                            Objects.equals(spielers[runde % 4].getWeg()[newpos][1], spielers[0].getWeg()[spielers[0].getSteine().get(i).getPos()][1])) {
                            spielers[0].getSteine().remove(i);
                            startfeldfuellen(0);
                        }
                    }
                    return true;
                }
            }
            if (map.getTile(spielers[runde%4].getWeg()[newpos][0], spielers[runde%4].getWeg()[newpos][1]) instanceof SpielerGelb) {
                if (runde%4 == 1) {
                    return false;
                } else {
                    for (int i = 0 ; i < spielers[1].getSteine().size(); i++) {
                        if (Objects.equals(spielers[runde % 4].getWeg()[newpos][0], spielers[1].getWeg()[spielers[1].getSteine().get(i).getPos()][0]) &&
                            Objects.equals(spielers[runde % 4].getWeg()[newpos][1], spielers[1].getWeg()[spielers[1].getSteine().get(i).getPos()][1])) {
                            spielers[1].getSteine().remove(i);
                            startfeldfuellen(1);
                        }
                    }
                    return true;
                }
            }
            if (map.getTile(spielers[runde%4].getWeg()[newpos][0], spielers[runde%4].getWeg()[newpos][1]) instanceof SpielerBlau) {
                if (runde%4 == 2) {
                    return false;
                } else {
                    for (int i = 0 ; i < spielers[2].getSteine().size(); i++) {
                        if (Objects.equals(spielers[runde % 4].getWeg()[newpos][0], spielers[2].getWeg()[spielers[2].getSteine().get(i).getPos()][0]) &&
                            Objects.equals(spielers[runde % 4].getWeg()[newpos][1], spielers[2].getWeg()[spielers[2].getSteine().get(i).getPos()][1])) {
                            spielers[2].getSteine().remove(i);
                            startfeldfuellen(2);
                        }
                    }
                    return true;
                }
            }
            if (map.getTile(spielers[runde%4].getWeg()[newpos][0], spielers[runde%4].getWeg()[newpos][1]) instanceof SpielerRot) {
                if (runde%4 == 3) {
                    return false;
                } else {
                    for (int i = 0 ; i < spielers[3].getSteine().size(); i++) {
                        if (Objects.equals(spielers[runde % 4].getWeg()[newpos][0], spielers[3].getWeg()[spielers[3].getSteine().get(i).getPos()][0]) &&
                            Objects.equals(spielers[runde % 4].getWeg()[newpos][1], spielers[3].getWeg()[spielers[3].getSteine().get(i).getPos()][1])) {
                            spielers[3].getSteine().remove(i);
                            startfeldfuellen(3);
                        }
                    }
                    return true;
                }
            }
        }
        return true;
    }

    public void spielzug(int diceRoll, int index) {
        //Stein kann frei ausgewählt werden
        int pos = spielers[runde%4].getSteine().get(index).getPos();
        int newPos = pos + diceRoll;
        switch (runde % 4) {
            case 0:
                if (zielfeldTest(newPos)) {
                    Tile field = new Field(spielers[runde%4].getWeg()[pos][0], spielers[runde%4].getWeg()[pos][1]);
                    Tile spielStein = spielers[runde%4].getSteine().get(index);
                    spielStein.setPos(newPos);
                    spielStein.setX(spielers[runde%4].getWeg()[newPos][0]);
                    spielStein.setY(spielers[runde%4].getWeg()[newPos][1]);
                    map.setTile(field);
                    map.setTile(spielStein);
                } else {
                    System.out.println("Zielfeld ist durch eigene Spielfigur blockiert.");
                }
                break;
            case 1:
                if (zielfeldTest(newPos)) {
                    Tile field = new Field(spielers[runde%4].getWeg()[pos][0], spielers[runde%4].getWeg()[pos][1]);
                    Tile spielStein = spielers[runde%4].getSteine().get(index);
                    spielStein.setPos(newPos);
                    spielStein.setX(spielers[runde%4].getWeg()[newPos][0]);
                    spielStein.setY(spielers[runde%4].getWeg()[newPos][1]);
                    map.setTile(field);
                    map.setTile(spielStein);
                } else {
                    System.out.println("Zielfeld ist durch eigenen Spielfigur blockiert.");
                }
                break;
            case 2:
                if (zielfeldTest(newPos)) {
                    Tile field = new Field(spielers[runde%4].getWeg()[pos][0], spielers[runde%4].getWeg()[pos][1]);
                    Tile spielStein = spielers[runde%4].getSteine().get(index);
                    spielStein.setPos(newPos);
                    spielStein.setX(spielers[runde%4].getWeg()[newPos][0]);
                    spielStein.setY(spielers[runde%4].getWeg()[newPos][1]);
                    map.setTile(field);
                    map.setTile(spielStein);
                } else {
                    System.out.println("Zielfeld ist durch eigenen Spielfigur blockiert.");
                }
                break;
            case 3:
                if (zielfeldTest(newPos)) {
                    Tile field = new Field(spielers[runde%4].getWeg()[pos][0], spielers[runde%4].getWeg()[pos][1]);
                    Tile spielStein = spielers[runde%4].getSteine().get(index);
                    spielStein.setPos(newPos);
                    spielStein.setX(spielers[runde%4].getWeg()[newPos][0]);
                    spielStein.setY(spielers[runde%4].getWeg()[newPos][1]);
                    map.setTile(field);
                    map.setTile(spielStein);
                } else {
                    System.out.println("Zielfeld ist durch eigenen Spielfigur blockiert.");
                }
                break;
        }
    }

}