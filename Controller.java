package com.thipasa.mrjack.ui;

import com.thipasa.mrjack.model.Board;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;


import java.net.URL;
import java.util.ArrayList;
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


        Event event = new Event();
        ArrayList<Button> buttonList = new ArrayList<>();
        event.MakeNButton(buttonList, 11);
        event.setButtonDisable(buttonList);
        event.setButtonPicture(buttonList);
        // Problème il faut associer le nom des variables  à Scène Builder PB elles n'ont pas de nom. Il faut trouver un moyen de dire à scene builder comment trouver ces boutons.
        Board myBoard = new Board();

        //this.buttom0.setStyle("-fx-background: url('../Pictures/districts/common-verso.png');");
    }
    public void pushed(ActionEvent e){
        //Ca exécute cette méthode en appuyant sur le bouton
    }

}