package com.geometryfx;
import javafx.scene.canvas.GraphicsContext;

public interface Figure {
    double area();
    double perimeter();
    void draw(GraphicsContext gc);
    boolean contains(double x, double y);
    void setPosition(double x, double y);
    double getX();
    double getY();
    void setColor(javafx.scene.paint.Color color);
    javafx.scene.paint.Color getColor();
}

