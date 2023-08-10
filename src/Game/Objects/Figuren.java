package Game.Objects;

import Game.Game;
import java.awt.*;

public abstract class Figuren extends GameObject{
    protected final Game game;
    protected double centerX;
    protected double centerY;
    protected Color color;
    protected final double radius;

    public Figuren(Game game, double centerX, double centerY, double radius, Color color){
        this.game = game;
        this.centerX = centerX;
        this.centerY = centerY;
        this.color = color;
        this.radius = radius;
    }

    public double getCenterX() {
        return centerX;
    }

    public double getCenterY() {
        return centerY;
    }



}
