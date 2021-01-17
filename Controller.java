package com.thipasa.mrjack.ui;

import com.thipasa.mrjack.model.Board;
import com.thipasa.mrjack.model.Orientation;
import com.thipasa.mrjack.players.InvestigatorPlayer;
import com.thipasa.mrjack.players.MrJackPlayer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    //Button pour les différents districts
    @FXML
    public Button button01;

    @FXML
    public Button button02;

    @FXML
    public Button button03;

    @FXML
    public Button button04;

    @FXML
    public Button button05;

    @FXML
    public Button button06;

    @FXML
    public Button button07;

    @FXML
    public Button button08;

    @FXML
    public Button button09;


    //Boutton pour les différents detectives
    @FXML
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

    @FXML
    public Button buttonAfficherAlibi;

    Board myBoard = new Board();
    //-----------------------------------------
    @FXML
    public Button buttonAfficher; //boutonTours
    //-----------------------------------------

    @FXML
    public Button buttonAct1;
    @FXML
    public Button buttonAct2;
    @FXML
    public Button buttonAct3;
    @FXML
    public Button buttonAct4;
    ///CHAT
    @FXML
    public TextArea textArea;
    @FXML
    public Button send;
    @FXML
    public TextField textField;
    public Label label1;
    public Label label2;
    public Button playGame;


    //Information pour leurs positionnement


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        //Initialisation du projet
        //Chat




        //------------------------------------------------------------

        this.button01.setDisable(true);
        //this.buttom01.getStyleClass().removeAll("nom de la classe");

        this.button02.setDisable(true);
        //this.buttom02.getStyleClass().removeAll("nom de la classe");

        this.button03.setDisable(true);
        //this.buttom03.getStyleClass().removeAll("nom de la classe");

        this.button04.setDisable(true);
        //this.buttom04.getStyleClass().removeAll("nom de la classe");

        this.button05.setDisable(true);
        //this.buttom05.getStyleClass().removeAll("nom de la classe");

        this.button06.setDisable(true);
        //this.buttom06.getStyleClass().removeAll("nom de la classe");

        this.button07.setDisable(true);
        //this.buttom07.getStyleClass().removeAll("nom de la classe");

        this.button08.setDisable(true);
        //this.buttom08.getStyleClass().removeAll("nom de la classe");

        this.button09.setDisable(true);
        //this.buttom09.getStyleClass().removeAll("nom de la classe");

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

        this.buttonAfficher.setDisable(false);
        this.buttonAfficher.getStyleClass().add("Tour1");


        //-------------------------------------------------------------------------------------------------------

        //this.buttom0.setStyle("-fx-background: url('../Pictures/districts/common-verso.png');");



        // Nom des joueurs
        myBoard.setAsk1("Quel est le nom du joueur enqueteur ?");
        TextInputDialog dialog = new TextInputDialog("Name");
        dialog.setHeaderText(myBoard.getAsk1());
        Optional<String> result = dialog.showAndWait();

        result.ifPresent(name -> {
            this.label1.setText(name);
        });
        String userName = label1.getText();
        InvestigatorPlayer investigatorPlayer = new InvestigatorPlayer(new ArrayList(), 0, userName);

        TextInputDialog dialog2 = new TextInputDialog("Name");
        myBoard.setAsk1("Quel est le nom du joueur MrJack ?");
        dialog2.setHeaderText(myBoard.getAsk1());
        result = dialog2.showAndWait();

        result.ifPresent(name -> {
            this.label2.setText(name);
        });

        userName = label2.getText();
        MrJackPlayer mrJackPlayer = new MrJackPlayer(new ArrayList(), 0, userName, myBoard.getMrJackCharacter2());

        ///////////////////////////////////////////////////////////

        this.textArea.setText(myBoard.getAsk1());

        //myBoard.getDistrict(0,0)
        this.button01.getStyleClass().add(myBoard.getDistrict(0, 0).getCharacter().getName());
        this.button01.setRotate(convertRotate(myBoard.getDistrict(0,0).getOrientation()));

        this.button02.getStyleClass().add(myBoard.getDistrict(0, 1).getCharacter().getName());
        this.button02.setRotate(convertRotate(myBoard.getDistrict(0,1).getOrientation()));

        this.button03.getStyleClass().add(myBoard.getDistrict(0, 2).getCharacter().getName());
        this.button03.setRotate(convertRotate(myBoard.getDistrict(0,2).getOrientation()));

        this.button04.getStyleClass().add(myBoard.getDistrict(1, 0).getCharacter().getName());
        this.button04.setRotate(convertRotate(myBoard.getDistrict(1,0).getOrientation()));

        this.button05.getStyleClass().add(myBoard.getDistrict(1, 1).getCharacter().getName());
        this.button05.setRotate(convertRotate(myBoard.getDistrict(1,1).getOrientation()));

        this.button06.getStyleClass().add(myBoard.getDistrict(1, 2).getCharacter().getName());
        this.button06.setRotate(convertRotate(myBoard.getDistrict(1,2).getOrientation()));

        this.button07.getStyleClass().add(myBoard.getDistrict(2, 0).getCharacter().getName());
        this.button07.setRotate(convertRotate(myBoard.getDistrict(2,0).getOrientation()));

        this.button08.getStyleClass().add(myBoard.getDistrict(2, 1).getCharacter().getName());
        this.button08.setRotate(convertRotate(myBoard.getDistrict(2,1).getOrientation()));

        this.button09.getStyleClass().add(myBoard.getDistrict(2, 2).getCharacter().getName());
        this.button09.setRotate(convertRotate(myBoard.getDistrict(2,2).getOrientation()));


        //-------------------------------------------------------------------------------------------------------

        this.buttonAct1.setDisable(false);
        this.buttonAct1.getStyleClass().add("ActionToken");

        this.buttonAct2.setDisable(false);
        this.buttonAct2.getStyleClass().add("ActionToken");

        this.buttonAct3.setDisable(false);
        this.buttonAct3.getStyleClass().add("ActionToken");

        this.buttonAct4.setDisable(false);
        this.buttonAct4.getStyleClass().add("ActionToken");


        this.buttonAct1.getStyleClass().add(myBoard.getActionToken(0).toString());
        this.buttonAct2.getStyleClass().add(myBoard.getActionToken(1).toString());
        this.buttonAct3.getStyleClass().add(myBoard.getActionToken(2).toString());
        this.buttonAct4.getStyleClass().add(myBoard.getActionToken(3).toString());

        //-------------------------------------------------------------------------------------------------------



    }



    //Convertisseur
    public int convertRotate(Orientation sens){
        if (sens == Orientation.WEST){
            return (90);
        }
        else if (sens == Orientation.SOUTH){
            return (180);
        }
        else if (sens == Orientation.EAST){
            return (270);
        }
        else{
            return (0);
        }
    }

    public void pushed(ActionEvent e) {
        //Ca exécute cette méthode en appuyant sur le bouton
        if ((Button)e.getSource() == buttonAct3){
            //System.out.println(this.myBoard.getActionToken(0).toString());
            if (myBoard.getActionToken(0).toString().equals("Piocherunalibi")){
                //System.out.println(myBoard.alibiDraw());
                this.buttonAfficherAlibi.getStyleClass().add("Gull");
                System.out.println(this.buttonAfficherAlibi.getStyleClass());
            }
            /*else{
                if (this.button1.getStyleClass().add("Watson") ==  true){

                }
                else if
                this.buttonAfficherAlibi.getStyleClass().add(myBoard.moveDetective());
            }*/

        }
    }
    public void send(){
        send.setOnAction(e -> System.out.println(textField.getText()));
    }



}