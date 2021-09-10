package com.study.javafx.window;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Window extends Application {

  @Override
  public void start(Stage primaryStage) {
    Button button = new Button("按钮");

    AnchorPane root = new AnchorPane();
    root.getChildren().addAll(button);
    // root.setCursor(new ImageCursor(new Image("./window/icon.png")));
    primaryStage.setScene(new Scene(root));
    primaryStage.getIcons().add(new Image("./window/icon.png"));
    primaryStage.setTitle("javafx demo");
    primaryStage.setHeight(300);
    primaryStage.setWidth(500);
    primaryStage.show();
  }
}
