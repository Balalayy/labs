package com.geometryfx;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.util.Random;

public class Main extends Application {
    private Canvas canvas;
    private GraphicsContext gc;
    private Random random = new Random();
    
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        
        // Создание холста
        canvas = new Canvas(600, 400);
        gc = canvas.getGraphicsContext2D();
        clearCanvas();
        
        // Панель с кнопками
        HBox buttonBox = new HBox(10);
        
        // Кнопка круга
        Button circleButton = new Button("Добавить круг");
        circleButton.setOnAction(e -> addCircle());
        
        // Кнопка прямоугольника
        Button rectangleButton = new Button("Добавить прямоугольник");
        rectangleButton.setOnAction(e -> addRectangle());
        
        // Кнопка очистки
        Button clearButton = new Button("Очистить");
        clearButton.setOnAction(e -> clearCanvas());
        
        // Кнопки добавляются в панель
        buttonBox.getChildren().addAll(circleButton, rectangleButton, clearButton);
        
        // Размещение кнопок и холста
        root.setTop(buttonBox);
        root.setCenter(canvas);
        
        // Создание окна с фигурами
        Scene scene = new Scene(root, 600, 450);
        primaryStage.setTitle("Фигуры");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private void addCircle() {
        // Рандомизация цвета и размера
        double radius = 20 + random.nextInt(50);
        Color color = getRandomColor();
        
        // Рандомная позиция
        double x = radius + random.nextInt((int)(canvas.getWidth() - radius * 2));
        double y = radius + random.nextInt((int)(canvas.getHeight() - radius * 2));
        
        // Создание круга
        Circle circle = new Circle(radius, color);
        circle.draw(gc, x, y);
        System.out.println("Оп! " + circle);
    }
    
    private void addRectangle() {
        // Рандомизация цвета и размера
        double width = 30 + random.nextInt(70);
        double height = 30 + random.nextInt(70);
        Color color = getRandomColor();
        
        // Рандомная позиция
        double x = width/2 + random.nextInt((int)(canvas.getWidth() - (int)width));
        double y = height/2 + random.nextInt((int)(canvas.getHeight() - (int)height));
        
        // Создание прямоугольника
        Rectangle rectangle = new Rectangle(width, height, color);
        rectangle.draw(gc, x, y);       
        System.out.println("Оп! " + rectangle);
    }
    
    private void clearCanvas() {
        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        System.out.println("Холст чист!");
    }
    
    private Color getRandomColor() {
        Color[] colors = {
            Color.RED, Color.BLUE, Color.GREEN, Color.ORANGE, 
            Color.PURPLE, Color.PINK, Color.BROWN, Color.CYAN
        };
        return colors[random.nextInt(colors.length)];
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}