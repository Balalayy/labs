package com.geometryfx;
import javafx.scene.canvas.GraphicsContext;

public interface Figure {
    double area();
    double perimeter();
    void draw(GraphicsContext gc, double x, double y);
}

