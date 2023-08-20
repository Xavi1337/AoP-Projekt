package Game.Objects.Tile;

import Game.Objects.GameObject;

public abstract class Tile extends GameObject {

    protected int x;

    protected int y;
    private int state;
    private int pos;

    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
        this.state = 1;
        this.pos = 0;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }
    public int getPos() { return pos; }

    public int getState() {return state;}
    public void setState(int state) {this.state = state;}
}
