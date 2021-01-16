package com.thipasa.mrjack.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(new File("resources/sample.fxml").toURI().toURL());
        primaryStage.setTitle("Mr Jack Pocket");
        //primaryStage.setScene(new Scene(root, 1800, 900));
        //primaryStage.show();

        Scene Mainscene = new Scene(root, 1800, 900);
        Mainscene.getStylesheets().add("CSSButtom.css");

        primaryStage.setScene(Mainscene);
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
