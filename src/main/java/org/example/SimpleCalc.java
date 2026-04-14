package org.example;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SimpleCalc extends Application {
    @Override
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new javafx.geometry.Insets(20));
        grid.setAlignment(Pos.CENTER);
        TextField tfNum1 = new TextField();
        TextField tfNum2 = new TextField();
        TextField tfResult = new TextField();
        tfResult.setEditable(false);
        grid.add(new Label("Number 1:"), 0, 0);
        grid.add(tfNum1, 1, 0);
        grid.add(new Label("Number 2:"), 0, 1);
        grid.add(tfNum2, 1, 1);
        grid.add(new Label("Result:"), 0, 2);
        grid.add(tfResult, 1, 2);
        Button btnCalc = new Button("Calculate");
        btnCalc.setOnAction(e -> {
            try {
                double n1 = Double.parseDouble(tfNum1.getText());
                double n2 = Double.parseDouble(tfNum2.getText());
                tfResult.setText(String.format("Sum: %.2f", n1 + n2));
            } catch (NumberFormatException ex) {
                tfResult.setText("Invalid input!");
            }
        });

        Button btnClear = new Button("Clear");
        btnClear.setOnAction(e -> {
            tfNum1.clear();
            tfNum2.clear();
            tfResult.clear();
        });

        grid.add(btnCalc, 0, 3);
        grid.add(btnClear, 1, 3);

        Scene scene = new Scene(grid);
        primaryStage.setTitle("Simple Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}