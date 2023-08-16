package Game.Objects;

import Game.Objects.Tile.Tile;
import java.util.ArrayList;

public class Player {

    private int versuche = 0;
    private ArrayList<Tile> steine;
    private Integer[][] weg;

    public Player(Integer[][] weg) {
        this.steine = new ArrayList<>();
        this.weg = weg;
    }

    public ArrayList<Tile> getSteine() {
        return steine;
    }
    public int getVersuche() {
        return versuche;
    }
    public void setVersuche(int versuche) {
        this.versuche = versuche;
    }
    public int getxpos() { return weg[0][0]; }
    public int getypos() { return weg[0][1]; }
    public Integer[][] getWeg() { return weg; }
}
