package com.geometryfx;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Rectangle implements Figure {
    double x, y;
    double width, height;
    Color color;
    
    public Rectangle(double x, double y, double w, double h) {
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;
        this.color = Color.RED;
    }
    
    public Rectangle(double x, double y, double w, double h, Color color) {
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;
        this.color = color;
    }

    public double area() {
        return width * height;
    }
    
    public double perimeter() {
        return 2 * (width + height);
    }
    
    public void draw(GraphicsContext gc) {
        gc.setFill(color);
        gc.fillRect(x - width/2, y - height/2, width, height);
    }
    
    public boolean contains(double pointX, double pointY) {
        double left = x - width/2;
        double right = x + width/2;
        double top = y - height/2;
        double bottom = y + height/2;
        
        return pointX >= left && pointX <= right && pointY >= top && pointY <= bottom;
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
        return "Представляю вам прямоугольник с основанием  " + width + " и высотой " + height + "!";
    }
}