package com.geometryfx;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Rectangle implements Figure {
    double width;
    double height;
    Color color;
    
    public Rectangle(double w, double h, Color color) {
        width = w;
        height = h;
        this.color = color;
    }
    
    public double area() {
        return width * height;
    }
    
    public double perimeter() {
        return 2 * (width + height);
    }
    
    public void draw(GraphicsContext gc, double x, double y) {
        gc.setFill(color);
        gc.fillRect(x - width/2, y - height/2, width, height);
    }
    
    public String toString() {
        return "Представляю вам прямоугольник с основанием  " + width + " и высотой " + height + "!";
    }
}