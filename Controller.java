package com.thipasa.mrjack.ui;

import com.thipasa.mrjack.model.Board;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML public Button buttom01;
    @FXML public Button buttom02;
    @FXML public Button buttom03;
    @FXML public Button buttom04;
    @FXML public Button buttom05;
    @FXML public Button buttom06;
    @FXML public Button buttom07;
    @FXML public Button buttom08;
    @FXML public Button buttom09;
    @FXML public Button buttom0;
    @FXML public Button buttom1;
    @FXML public Button buttom2;
    @FXML public Button buttom3;
    @FXML public Button buttom4;
    @FXML public Button buttom5;
    @FXML public Button buttom6;
    @FXML public Button buttom7;
    @FXML public Button buttom8;
    @FXML public Button buttom9;
    @FXML public Button buttom10;
    @FXML public Button buttom11;


    @Override
    public void initialize(URL arg0, ResourceBundle arg1){
        /**Initialisation du projet */
        this.buttom01.setDisable(true);
        //this.buttom01.getStyleClass().removeAll("nom de la classe");
        this.buttom01.getStyleClass().add("Alibi");

        this.buttom02.setDisable(true);
        //this.buttom02.getStyleClass().removeAll("nom de la classe");
        this.buttom02.getStyleClass().add("Alibi");

        this.buttom03.setDisable(true);
        //this.buttom03.getStyleClass().removeAll("nom de la classe");
        this.buttom03.getStyleClass().add("Alibi");

        this.buttom04.setDisable(true);
        //this.buttom04.getStyleClass().removeAll("nom de la classe");
        this.buttom04.getStyleClass().add("Alibi");

        this.buttom05.setDisable(true);
        //this.buttom05.getStyleClass().removeAll("nom de la classe");
        this.buttom05.getStyleClass().add("Alibi");

        this.buttom06.setDisable(true);
        //this.buttom06.getStyleClass().removeAll("nom de la classe");
        this.buttom06.getStyleClass().add("Alibi");

        this.buttom07.setDisable(true);
        //this.buttom07.getStyleClass().removeAll("nom de la classe");
        this.buttom07.getStyleClass().add("Alibi");

        this.buttom08.setDisable(true);
        //this.buttom08.getStyleClass().removeAll("nom de la classe");
        this.buttom08.getStyleClass().add("Alibi");

        this.buttom09.setDisable(true);
        //this.buttom09.getStyleClass().removeAll("nom de la classe");
        this.buttom09.getStyleClass().add("Alibi");

        this.buttom0.setDisable(true);
        //this.buttom0.getStyleClass().removeAll("nom de la classe");
        this.buttom0.getStyleClass().add("Alibi");

        this.buttom1.setDisable(true);
        //this.buttom1.getStyleClass().removeAll("nom de la classe");
        this.buttom1.getStyleClass().add("Alibi");

        this.buttom2.setDisable(true);
        //this.buttom2.getStyleClass().removeAll("nom de la classe");
        this.buttom2.getStyleClass().add("Alibi");

        this.buttom3.setDisable(true);
        //this.buttom3.getStyleClass().removeAll("nom de la classe");
        this.buttom3.getStyleClass().add("Alibi3");

        this.buttom4.setDisable(true);
        //this.buttom4.getStyleClass().removeAll("nom de la classe");
        this.buttom4.getStyleClass().add("Alibi");

        this.buttom5.setDisable(true);
        //this.buttom5.getStyleClass().removeAll("nom de la classe");
        this.buttom5.getStyleClass().add("Alibi");

        this.buttom6.setDisable(true);
        //this.buttom6.getStyleClass().removeAll("nom de la classe");
        this.buttom6.getStyleClass().add("Alibi6");

        this.buttom7.setDisable(true);
        //this.buttom7.getStyleClass().removeAll("nom de la classe");
        this.buttom7.getStyleClass().add("Alibi");

        this.buttom8.setDisable(true);
        //this.buttom8.getStyleClass().removeAll("nom de la classe");
        this.buttom8.getStyleClass().add("Alibi");

        this.buttom9.setDisable(true);
        //this.buttom9.getStyleClass().removeAll("nom de la classe");
        this.buttom9.getStyleClass().add("Alibi");

        this.buttom10.setDisable(true);
        //this.buttom10.getStyleClass().removeAll("nom de la classe");
        this.buttom10.getStyleClass().add("Alibi");

        this.buttom11.setDisable(true);
        //this.buttom11.getStyleClass().removeAll("nom de la classe");
        this.buttom11.getStyleClass().add("Alibi11");


        Board myBoard = new Board();

        //this.buttom0.setStyle("-fx-background: url('../Pictures/districts/common-verso.png');");
    }
    public void pushed(ActionEvent e){
        //Ca exécute cette méthode en appuyant sur le bouton
    }

}