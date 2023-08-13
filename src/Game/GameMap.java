package Game;

import java.awt.Graphics2D;

import Game.Objects.GameObject;
import Game.Objects.Tile.*;

public class GameMap extends GameObject{

    private static final int[][] DEFAULT_MAP ={
            {100, 100, 0, 0, 9, 10, 11, 0, 0, 101, 101},
            {100, 100, 0, 0, 8, 101, 12, 0, 0, 101, 101},
            {0, 0, 0, 0, 7, 101, 13, 0, 0, 0, 0},
            {0, 0, 0, 0, 6, 101, 14, 0, 0, 0, 0},
            {1, 2, 3, 4, 5, 101, 15, 16, 17, 18, 19},
            {40, 100, 100, 100, 100, 0, 103, 103, 103, 103, 20},
            {39, 38, 37, 36, 35, 102, 25, 24, 23, 22, 21},
            {0, 0, 0, 0, 34, 102, 26, 0, 0, 0, 0},
            {0, 0, 0, 0, 33, 102, 27, 0, 0, 0, 0},
            {102, 102, 0, 0, 32, 102, 28, 0, 0, 103, 103},
            {102, 102, 0, 0, 31, 30, 29, 0, 0, 103, 103},
    };
    public final int tileSize;

    private final Tile[][] tiles;



    public GameMap (int tileSize) {
        this.tileSize = tileSize;
        tiles = new Tile[DEFAULT_MAP.length][DEFAULT_MAP[0].length];

        for(int y = 0; y < getHeight(); y++ ) {
            for(int x = 0; x < getWidth(); x++) {
                int tileId = DEFAULT_MAP[y][x];

                if (tileId >= 1 & tileId <= 40) {
                    tiles[x][y] = new Field(x, y);
                } else if (tileId == 0) {
                    tiles[x][y] = new Air(x, y);
                } else if (tileId == 100) {
                    tiles[x][y] = new StartGreen(x, y);
                } else if (tileId == 101) {
                    tiles[x][y] = new StartYellow(x, y);
                } else if (tileId == 102) {
                    tiles[x][y] = new StartBlue(x, y);
                } else if (tileId == 103) {
                    tiles[x][y] = new StartRed(x, y);
                }

            }
        }
        tiles[0][0] = new SpielerRot(0,0);
        tiles[0][1] = new SpielerRot(0,1);
        tiles[1][0] = new SpielerRot(1,0);
        tiles[1][1] = new SpielerRot(1,1);

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

    public void setTile(int x, int y, Tile tile) {
        tiles[y][x] = tile;
    }



}

