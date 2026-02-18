package com.geometryfx;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Circle implements Figure {
    double x, y;
    double radius;
    Color color;
    
    public Circle(double x, double y, double r) {
        this.x = x;
        this.y = y;
        this.radius = r;
        this.color = Color.BLUE;
    }
    
    public Circle(double x, double y, double r, Color color) {
        this.x = x;
        this.y = y;
        this.radius = r;
        this.color = color;
    }
    
    public double area() {
        return 3.14 * radius * radius;
    }
    
    public double perimeter() {
        return 2 * 3.14 * radius;
    }
    
    public void draw(GraphicsContext gc) {
        gc.setFill(color);
        gc.fillOval(x - radius, y - radius, radius * 2, radius * 2);
        
    }

    public boolean contains(double pointX, double pointY) {
        double dx = pointX - x;
        double dy = pointY - y;
        return (dx * dx + dy * dy) <= (radius * radius);
    }

    public void setPosition(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() { return x; }
    public double getY() { return y; }
    
    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
    
    public String toString() {
        return "Представляю вам круг с радиусом " + radius + "!";
    }
}