package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class KeyLogger extends Application {
    @Override
    public void start(Stage primaryStage) {
        TextField tfInput = new TextField();
        TextArea taLog = new TextArea();
        taLog.setEditable(false);
        taLog.setPrefRowCount(5); // 5 rows [4]

        tfInput.setOnKeyPressed(e -> {
            taLog.appendText(String.format("PRESSED | Code: %s | Shift: %b | Ctrl: %b\n",
                    e.getCode(), e.isShiftDown(), e.isControlDown()));
        });

        tfInput.setOnKeyReleased(e -> {
            taLog.appendText("RELEASED | Code: " + e.getCode() + "\n");
        });

        tfInput.setOnKeyTyped(e -> {
            taLog.appendText("TYPED | Char: " + e.getCharacter() + "\n");
        });

        Button btnClear = new Button("Clear Log");
        btnClear.setOnAction(e -> taLog.clear());

        VBox root = new VBox(10, tfInput, taLog, btnClear);
        root.setPadding(new javafx.geometry.Insets(20));

        Scene scene = new Scene(root, 420, 320);
        primaryStage.setTitle("Key Event Logger");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
