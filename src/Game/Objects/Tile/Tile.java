package Game.Objects.Tile;

import Game.Objects.GameObject;

public abstract class Tile extends GameObject {

    protected final int x;

    protected final int y;
    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
}
