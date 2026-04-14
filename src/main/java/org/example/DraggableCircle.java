package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class DraggableCircle extends Application {
    private double offsetX, offsetY;

    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        root.setPrefSize(500, 400);

        Circle circle = new Circle(250, 200, 40, Color.CORAL); // Radius 40, center [5, 6]

        circle.setOnMousePressed(e -> {
            offsetX = e.getSceneX() - circle.getCenterX(); // Record offset [6]
            offsetY = e.getSceneY() - circle.getCenterY();
            circle.setFill(Color.TOMATO); // Color change while dragging [6]
        });

        circle.setOnMouseDragged(e -> {
            circle.setCenterX(e.getSceneX() - offsetX); // Follow mouse smoothly [6]
            circle.setCenterY(e.getSceneY() - offsetY);
        });

        circle.setOnMouseReleased(e -> circle.setFill(Color.CORAL)); // Revert color [6]

        root.getChildren().add(circle);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
