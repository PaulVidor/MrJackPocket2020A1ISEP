package com.thipasa.mrjack.ui;

import com.thipasa.mrjack.model.Alibi;
import com.thipasa.mrjack.model.Board;
import com.thipasa.mrjack.players.Detective;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.transform.TransformChangedEvent;

import javax.swing.event.ChangeListener;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    //Button pour les différents districts
    @FXML
    public Button button01;
    public Button button01_90;
    public Button button01_180;
    public Button button01_270;
    @FXML
    public Button button02;
    public Button button02_90;
    public Button button02_180;
    public Button button02_270;
    @FXML
    public Button button03;
    public Button button03_90;
    public Button button03_180;
    public Button button03_270;
    @FXML
    public Button button04;
    public Button button04_90;
    public Button button04_180;
    public Button button04_270;
    @FXML
    public Button button05;
    public Button button05_90;
    public Button button05_180;
    public Button button05_270;
    @FXML
    public Button button06;
    public Button button06_90;
    public Button button06_180;
    public Button button06_270;
    @FXML
    public Button button07;
    public Button button07_90;
    public Button button07_180;
    public Button button07_270;
    @FXML
    public Button button08;
    public Button button08_90;
    public Button button08_180;
    public Button button08_270;
    @FXML
    public Button button09;
    public Button button09_90;
    public Button button09_180;
    public Button button09_270;
    @FXML

    public Button[][] degButton = {
            {button01, button01_90, button01_180, button01_270},
            {button02, button02_90, button02_180, button02_270},
            {button03, button03_90, button03_180, button03_270},
            {button04, button04_90, button04_180, button04_270},
            {button05, button05_90, button05_180, button05_270},
            {button06, button06_90, button06_180, button06_270},
            {button07, button07_90, button07_180, button07_270},
            {button08, button08_90, button08_180, button08_270},
            {button09, button09_90, button09_180, button09_270}
    };

    //Boutton pour les différents détectives
    public Button button0;
    @FXML
    public Button button1;
    @FXML
    public Button button2;
    @FXML
    public Button button3;
    @FXML
    public Button button4;
    @FXML
    public Button button5;
    @FXML
    public Button button6;
    @FXML
    public Button button7;
    @FXML
    public Button button8;
    @FXML
    public Button button9;
    @FXML
    public Button button10;
    @FXML
    public Button button11;

    //Information pour leurs positionnement

    public Detective Sherlock;
    private int bSherlock;
    public Detective Watson;
    private int bWatson;
    public Detective Tobi;
    private int bTobi;


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        /**Initialisation du projet */

        //------------------------------------------------------------

        this.button01.setDisable(true);
        //this.buttom01.getStyleClass().removeAll("nom de la classe");
        this.button01.getStyleClass().add("Alibi0");

        this.button02.setDisable(true);
        //this.buttom02.getStyleClass().removeAll("nom de la classe");
        this.button02.getStyleClass().add("Alibi");

        this.button03.setDisable(true);
        //this.buttom03.getStyleClass().removeAll("nom de la classe");
        this.button03.getStyleClass().add("Alibi");

        this.button04.setDisable(true);
        //this.buttom04.getStyleClass().removeAll("nom de la classe");
        this.button04.getStyleClass().add("Alibi");

        this.button05.setDisable(true);
        //this.buttom05.getStyleClass().removeAll("nom de la classe");
        this.button05.getStyleClass().add("Alibi");

        this.button06.setDisable(true);
        //this.buttom06.getStyleClass().removeAll("nom de la classe");
        this.button06.getStyleClass().add("Alibi");

        this.button07.setDisable(true);
        //this.buttom07.getStyleClass().removeAll("nom de la classe");
        this.button07.getStyleClass().add("Alibi");

        this.button08.setDisable(true);
        //this.buttom08.getStyleClass().removeAll("nom de la classe");
        this.button08.getStyleClass().add("Alibi");

        this.button09.setDisable(true);
        //this.buttom09.getStyleClass().removeAll("nom de la classe");
        this.button09.getStyleClass().add("Alibi");

        //-------------------------------------------------------------

        this.button0.setDisable(true);
        //this.buttom0.getStyleClass().removeAll("nom de la classe");
        this.button0.getStyleClass().add("Alibi");

        this.button1.setDisable(true);
        //this.buttom1.getStyleClass().removeAll("nom de la classe");
        this.button1.getStyleClass().add("Alibi");

        this.button2.setDisable(true);
        //this.buttom2.getStyleClass().removeAll("nom de la classe");
        this.button2.getStyleClass().add("Alibi");

        this.button3.setDisable(true);
        //this.buttom3.getStyleClass().removeAll("nom de la classe");
        this.button3.getStyleClass().add("Watson");

        this.button4.setDisable(true);
        //this.buttom4.getStyleClass().removeAll("nom de la classe");
        this.button4.getStyleClass().add("Alibi");

        this.button5.setDisable(true);
        //this.buttom5.getStyleClass().removeAll("nom de la classe");
        this.button5.getStyleClass().add("Alibi");

        this.button6.setDisable(true);
        //this.buttom6.getStyleClass().removeAll("nom de la classe");
        this.button6.getStyleClass().add("Tobi");

        this.button7.setDisable(true);
        //this.buttom7.getStyleClass().removeAll("nom de la classe");
        this.button7.getStyleClass().add("Alibi");

        this.button8.setDisable(true);
        //this.buttom8.getStyleClass().removeAll("nom de la classe");
        this.button8.getStyleClass().add("Alibi");

        this.button9.setDisable(true);
        //this.buttom9.getStyleClass().removeAll("nom de la classe");
        this.button9.getStyleClass().add("Alibi");

        this.button10.setDisable(true);
        //this.buttom10.getStyleClass().removeAll("nom de la classe");
        this.button10.getStyleClass().add("Alibi");

        this.button11.setDisable(true);
        //this.buttom11.getStyleClass().removeAll("nom de la classe");
        this.button11.getStyleClass().add("Sherlock1");


        //-------------------------------------------------------------------------------------------------------

        //this.buttom0.setStyle("-fx-background: url('../Pictures/districts/common-verso.png');");

        Board myBoard = new Board();

        this.button01.getStyleClass().add(myBoard.getDistrict(0, 0).getCharacter().getName());
        this.button02.getStyleClass().add(myBoard.getDistrict(0, 1).getCharacter().getName());
        this.button03.getStyleClass().add(myBoard.getDistrict(0, 2).getCharacter().getName());
        this.button04.getStyleClass().add(myBoard.getDistrict(1, 0).getCharacter().getName());
        this.button05.getStyleClass().add(myBoard.getDistrict(1, 1).getCharacter().getName());
        this.button06.getStyleClass().add(myBoard.getDistrict(1, 2).getCharacter().getName());
        this.button07.getStyleClass().add(myBoard.getDistrict(2, 0).getCharacter().getName());
        this.button08.getStyleClass().add(myBoard.getDistrict(2, 1).getCharacter().getName());
        this.button09.getStyleClass().add(myBoard.getDistrict(2, 2).getCharacter().getName());


    }

    public void pushed(ActionEvent e) {
        //Ca exécute cette méthode en appuyant sur le bouton
    }

}