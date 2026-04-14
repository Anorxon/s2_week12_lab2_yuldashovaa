package org.example;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ClickCounter extends Application {
    private int counter = 0;

    @Override
    public void start(Stage primaryStage) {
        Label lblClicks = new Label("Clicks: 0");
        lblClicks.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        Button btnClick = new Button("Click me!");
        btnClick.setOnAction(e -> {
            counter++;
            lblClicks.setText("Clicks: " + counter); // Increment and update label [1]
        });
        VBox root = new VBox(20, lblClicks, btnClick); // Spacing 20 [1]
        root.setAlignment(Pos.CENTER); // Centered [1]
        root.setPadding(new javafx.geometry.Insets(30)); // Padding 30 [1]

        Scene scene = new Scene(root, 300, 200); // Scene size 300x200 [2]
        primaryStage.setTitle("Click Counter"); // Window title [2]
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
