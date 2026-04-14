package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class KeyboardMove extends Application {
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        pane.setPrefSize(500, 400);

        Rectangle rect = new Rectangle(220, 180, 60, 40);
        rect.setFill(Color.BLUE);
        pane.getChildren().add(rect);

        TextField tfPos = new TextField("X: 220 Y: 180");
        tfPos.setEditable(false);

        BorderPane root = new BorderPane();
        root.setCenter(pane);
        root.setBottom(tfPos);

        Scene scene = new Scene(root, 500, 450);
        scene.setOnKeyPressed(e -> {
            double x = rect.getX();
            double y = rect.getY();
            if (e.getCode() == KeyCode.UP) y -= 10;
            if (e.getCode() == KeyCode.DOWN) y += 10;
            if (e.getCode() == KeyCode.LEFT) x -= 10;
            if (e.getCode() == KeyCode.RIGHT) x += 10;
            x = Math.max(0, Math.min(x, 500 - 60));
            y = Math.max(0, Math.min(y, 400 - 40));
            rect.setX(x);
            rect.setY(y);
            tfPos.setText(String.format("X: %.0f Y: %.0f", x, y));
        });

        primaryStage.setScene(scene);
        primaryStage.show();

        scene.getRoot().requestFocus();
    }
}