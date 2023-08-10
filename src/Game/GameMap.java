package Game;

import java.awt.Graphics2D;

import Game.Objects.GameObject;
import Game.Objects.Tile.Air;
import Game.Objects.Tile.Field;
import Game.Objects.Tile.StartBlue;
import Game.Objects.Tile.StartGreen;
import Game.Objects.Tile.StartRed;
import Game.Objects.Tile.StartYellow;
import Game.Objects.Tile.Tile;

public class GameMap extends GameObject{

    private static final int[][] DEFAULT_MAP ={
            {4, 4, 0, 0, 1, 1, 3, 0, 0, 3, 3},
            {4, 4, 0, 0, 1, 3, 1, 0, 0, 3, 3},
            {0, 0, 0, 0, 1, 3, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 3, 1, 0, 0, 0, 0},
            {4, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1},
            {1, 4, 4, 4, 4, 0, 2, 2, 2, 2, 1},
            {1, 1, 1, 1, 1, 5, 1, 1, 1, 1, 2},
            {0, 0, 0, 0, 1, 5, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 5, 1, 0, 0, 0, 0},
            {5, 5, 0, 0, 1, 5, 1, 0, 0, 2, 2},
            {5, 5, 0, 0, 5, 1, 1, 0, 0, 2, 2},
    };
    private final int tileSize;

    private final Tile[][] tiles;


    public GameMap (int tileSize) {
        this.tileSize = tileSize;
        tiles = new Tile[DEFAULT_MAP.length][DEFAULT_MAP[0].length];

        for(int y = 0; y < getHeight(); y++ ) {
            for(int x = 0; x < getWidth(); x++) {
                int tileId = DEFAULT_MAP[y][x];

                if(tileId == 1) {
                    tiles[x][y] = new Field(x, y);
                }else if (tileId == 0) {
                    tiles[x][y] = new Air(x, y);
                }else if (tileId == 3) {
                    tiles[x][y] = new StartGreen(x, y);
                }else if( tileId == 4) {
                    tiles[x][y] = new StartYellow(x, y);
                }else if (tileId == 5) {
                    tiles[x][y] = new StartBlue(x, y);
                }else if (tileId == 2) {
                    tiles[x][y] = new StartRed(x, y);
                }

            }
        }
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

