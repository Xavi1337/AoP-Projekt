package Game;

import java.awt.Graphics2D;
import Game.Objects.GameObject;
import Game.Objects.Tile.*;

public class GameMap extends GameObject{

    public int[][] getDEFAULT_MAP() {
        return DEFAULT_MAP;
    }

    private final int[][] DEFAULT_MAP ={
        {100, 100,   0,   0,   9,  10,  11,   0,   0, 102, 102},
        {100, 100,   0,   0,   8, 103,  12,   0,   0, 102, 102},
        {  0,   0,   0,   0,   7, 103,  13,   0,   0,   0,   0},
        {  0,   0,   0,   0,   6, 103,  14,   0,   0,   0,   0},
        {  1,   2,   3,   4,   5, 103,  15,  16,  17,  18,  19},
        { 40, 101, 101, 101, 101,   0, 105, 105, 105, 105,  20},
        { 39,  38,  37,  36,  35, 107,  25,  24,  23,  22,  21},
        {  0,   0,   0,   0,  34, 107,  26,   0,   0,   0,   0},
        {  0,   0,   0,   0,  33, 107,  27,   0,   0,   0,   0},
        {106, 106,   0,   0,  32, 107,  28,   0,   0, 104, 104},
        {106, 106,   0,   0,  31,  30,  29,   0,   0, 104, 104},
    };

    public final int tileSize;

    private static Tile[][] tiles;

    public GameMap (int tileSize) {
        this.tileSize = tileSize;
        tiles = new Tile[DEFAULT_MAP.length][DEFAULT_MAP[0].length];

        for(int x = 0; x < getHeight(); x++) {
            for(int y = 0; y < getWidth(); y++) {
                int tileId = DEFAULT_MAP[y][x];

                if (tileId >= 1 & tileId <= 40) {
                    tiles[x][y] = new Field(x, y);
                } else if (tileId == 0) {
                    tiles[x][y] = new Air(x, y);
                } else if (tileId == 100) {
                    tiles[x][y] = new StartGreen(x, y);
                } else if (tileId == 101) {
                    tiles[x][y] = new ZielGreen(x, y);
                } else if (tileId == 102) {
                    tiles[x][y] = new StartYellow(x, y);
                } else if (tileId == 103) {
                    tiles[x][y] = new ZielYellow(x, y);
                } else if (tileId == 104) {
                    tiles[x][y] = new StartBlue(x, y);
                } else if (tileId == 105) {
                    tiles[x][y] = new ZielBlue(x, y);
                } else if (tileId == 106) {
                    tiles[x][y] = new StartRed(x, y);
                } else if (tileId == 107) {
                    tiles[x][y] = new ZielRed(x, y);
                }
            }
        }
        //tiles[0][0] = new SpielerRot(0,0);
        //tiles[0][1] = new SpielerRot(0,1);
        //tiles[1][0] = new SpielerRot(1,0);
        //tiles[1][1] = new SpielerRot(1,1);
    }

    public int getWidth() {
        return tiles[0].length;
    }

    public int getHeight() {
        return tiles.length;
    }

    @Override
    public void render(Graphics2D g, int tileSize) {
        for(Tile[] row : tiles) {
            for(Tile tile :row) {
                tile.render(g, tileSize);
            }
        }
    }

    public int getTileSize() {
        return tileSize;
    }

    public Tile getTile(int x, int y) {
        return tiles[y][x];
    }

    public void setTile(Tile tile) {
        tiles[tile.getY()][tile.getX()] = tile;
    }
}

