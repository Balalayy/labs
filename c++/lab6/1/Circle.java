package com.geometryfx;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Circle implements Figure {
    double radius;
    Color color;
    
    public Circle(double r) {
        radius = r;
        this.color = Color.BLUE;
    }
    
    public Circle(double r, Color color) {
        radius = r;
        this.color = color;
    }
    
    public double area() {
        return 3.14 * radius * radius;
    }
    
    public double perimeter() {
        return 2 * 3.14 * radius;
    }
    
    public void draw(GraphicsContext gc, double x, double y) {
        gc.setFill(color);
        gc.fillOval(x - radius, y - radius, radius * 2, radius * 2);
    }
    
    public String toString() {
        return "Представляю вам круг с радиусом " + radius + "!";
    }
}