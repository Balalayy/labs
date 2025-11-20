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
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main extends Application {
    private Canvas canvas;
    private GraphicsContext gc;
    private Random random = new Random();
    private List<Figure> figures = new ArrayList<>();
    private Figure draggedFigure = null;
    private double dragOffsetX, dragOffsetY;
    
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
        
        // Обработка мыши
        setupMouse();

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
        Circle circle = new Circle(x, y, radius, color);
        figures.add(circle);
        System.out.println("Оп! " + circle);
        redrawCanvas();
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
        Rectangle rectangle = new Rectangle(x, y, width, height, color);
        figures.add(rectangle);       
        System.out.println("Оп! " + rectangle);
        redrawCanvas();
    }
    
    private void clearCanvas() {
        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }
    
    private Color getRandomColor() {
        Color[] colors = {
            Color.RED, Color.BLUE, Color.GREEN, Color.ORANGE, 
            Color.PURPLE, Color.PINK, Color.BROWN, Color.CYAN
        };
        return colors[random.nextInt(colors.length)];
    }

    

    private void setupMouse() {
        
        // Обработка нажатий мыши
        canvas.setOnMousePressed(event -> {
        double mouseX = event.getX();
        double mouseY = event.getY();
            
            // Определяется, если ли фигура под курсором
            Figure clickedFigure = null;
            for (int i = figures.size() - 1; i >= 0; i--) {
                Figure figure = figures.get(i);
                if (figure.contains(mouseX, mouseY)) {
                    clickedFigure = figure;
                    break;
                }
            }
            
            if (clickedFigure != null) {
                if (event.isPrimaryButtonDown()) {
                    draggedFigure = clickedFigure;
                    dragOffsetX = mouseX - clickedFigure.getX();
                    dragOffsetY = mouseY - clickedFigure.getY();  
                    
                    // Наложение фигур
                    figures.remove(clickedFigure);
                    figures.add(clickedFigure);
                    redrawCanvas();
                }
                else if (event.isSecondaryButtonDown()) {
                    Color newColor = getRandomColor();
                    clickedFigure.setColor(newColor);
                    redrawCanvas();
                }
            }
        });
        
        // Обработка перемещения мыши
        canvas.setOnMouseDragged(event -> {
            if (draggedFigure != null && event.isPrimaryButtonDown()) {
                double newX = event.getX() - dragOffsetX;
                double newY = event.getY() - dragOffsetY;                
                draggedFigure.setPosition(newX, newY);
                redrawCanvas();
            }
        });
        
        // Обработка отпускания кнопки мыши
        canvas.setOnMouseReleased(event -> {
            if (draggedFigure != null) {
                draggedFigure = null;
            }
        });
    }

    private void redrawCanvas() {
        clearCanvas();
        for (Figure figure : figures) {
            figure.draw(gc);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}