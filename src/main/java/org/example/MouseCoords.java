package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MouseCoords extends Application {
    @Override
    public void start(Stage primaryStage) {
        StackPane stack = new StackPane();
        stack.setPrefSize(400, 300);
        stack.setStyle("-fx-background-color: lightblue;");

        Label lblPos = new Label("Move the mouse over the pane");

        stack.setOnMouseMoved(e -> {
            lblPos.setText(String.format("X: %.1f Y: %.1f", e.getX(), e.getY()));
        });

        stack.setOnMouseClicked(e -> {
            int r = (int)(Math.random() * 256);
            int g = (int)(Math.random() * 256);
            int b = (int)(Math.random() * 256);
            stack.setStyle(String.format("-fx-background-color: rgb(%d,%d,%d);", r, g, b));
        });

        stack.setOnMouseExited(e -> lblPos.setText("Move the mouse over the pane"));

        BorderPane root = new BorderPane();
        root.setCenter(stack);
        root.setBottom(lblPos);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}