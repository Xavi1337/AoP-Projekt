package Game.Objects;

import Game.Game;
import java.awt.*;

public abstract class Figurenposition extends GameObject {
    protected double centerX;
    protected double centerY;
    protected Color color;
    protected final double radius;

    public Figurenposition(double centerX, double centerY, double radius, Color color){
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
