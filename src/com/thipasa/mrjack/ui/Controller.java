package com.thipasa.mrjack.ui;

import com.thipasa.mrjack.game.Game;
import com.thipasa.mrjack.model.Board;
import com.thipasa.mrjack.model.Orientation;
import com.thipasa.mrjack.players.InvestigatorPlayer;
import com.thipasa.mrjack.players.MrJackPlayer;
import javafx.beans.DefaultProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.paint.CycleMethod;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    Game game = new Game();


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
    public Button MrJackPoints;

    @FXML
    public Button buttonAfficherAlibi;
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
    Boolean isAlibisPrint = false;
    boolean rotateButtonClicked;

    @FXML
    private List<Button> labelList ;

    int compteur = 0;
    int compteur2 = 0;
    //Information pour leurs positionnement


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {


        for (Button button : labelList) {
            //System.out.println(button.getId());
            button.setDisable(false);
            button.getStyleClass().add(game.getBoard().getDistrict(compteur, compteur2).getCharacter().getName());
            //System.out.println(compteur);
            //System.out.println(compteur2);

            button.setRotate(convertRotate(game.getBoard().getDistrict(compteur,compteur2).getOrientation()));

            //System.out.println(compteur2);
            //System.out.println(compteur);
            if (compteur2 == 2 ){
                this.compteur = compteur +1;
                this.compteur2 = 0;

            }else{
                this.compteur2 = compteur2 +1;
            }
        }
        //Initialisation du projet
        //Afficher un alibis var

        //Chat

        //------------------------------------------------------------
        /*ArrayList<Button> List = new ArrayList<>();

        for(int i =  1; i<10;i++){
            List.add(new Button());

        }

        for(int i = 0; i<9;i++){
            int j = i + 49;
            List.get(i).setId("button0"+ (char) j);
            System.out.println(List.get(i).getId());
            List.get(i).setDisable(true);
            for(int k = 0;k<3;k++){
                for(int l = 0;l<3;l++){
                    List.get(i).getStyleClass().add(game.getBoard().getDistrict(k, l).getCharacter().getName());
                    List.get(i).setRotate(convertRotate(game.getBoard().getDistrict(k,l).getOrientation()));
                }
            }
        }*/



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
        this.button3.getStyleClass().add("Sherlock");

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
        this.button11.getStyleClass().add("Watson");

        this.buttonAfficher.setDisable(false);
        this.buttonAfficher.getStyleClass().add("Tour1");


        //-------------------------------------------------------------------------------------------------------

        //this.buttom0.setStyle("-fx-background: url('../Pictures/districts/common-verso.png');");



        // Nom des joueurs
        game.getBoard().setAsk1("Quel est le nom du joueur enqueteur ?");
        TextInputDialog dialog = new TextInputDialog("Name");
        dialog.setHeaderText(game.getBoard().getAsk1());
        Optional<String> result = dialog.showAndWait();

        result.ifPresent(name -> {
            this.label1.setText(name);
        });
        String userName = label1.getText();
        InvestigatorPlayer investigatorPlayer = new InvestigatorPlayer(new ArrayList(), userName);
        game.getBoard().setInvestigatorPlayer(investigatorPlayer);

        TextInputDialog dialog2 = new TextInputDialog("Name");
        game.getBoard().setAsk1("Quel est le nom du joueur MrJack ?");
        dialog2.setHeaderText(game.getBoard().getAsk1());
        result = dialog2.showAndWait();


        result.ifPresent(name -> {
            this.label2.setText(name);
        });

        userName = label2.getText();
        MrJackPlayer mrJackPlayer = new MrJackPlayer(new ArrayList(), userName, game.getBoard().getMrJackCharacter2());
        game.getBoard().setMrJackPlayer(mrJackPlayer);

        ///////////////////////////////////////////////////////////

        this.textArea.setText(game.getBoard().getAsk1());

        //game.getBoard().getDistrict(0,0)
       /* this.button01.getStyleClass().add(game.getBoard().getDistrict(0, 0).getCharacter().getName());
        this.button01.setRotate(convertRotate(game.getBoard().getDistrict(0,0).getOrientation()));


        this.button02.getStyleClass().add(game.getBoard().getDistrict(0, 1).getCharacter().getName());
        this.button02.setRotate(convertRotate(game.getBoard().getDistrict(0,1).getOrientation()));

        this.button03.getStyleClass().add(game.getBoard().getDistrict(0, 2).getCharacter().getName());
        this.button03.setRotate(convertRotate(game.getBoard().getDistrict(0,2).getOrientation()));

        this.button04.getStyleClass().add(game.getBoard().getDistrict(1, 0).getCharacter().getName());
        this.button04.setRotate(convertRotate(game.getBoard().getDistrict(1,0).getOrientation()));

        this.button05.getStyleClass().add(game.getBoard().getDistrict(1, 1).getCharacter().getName());
        this.button05.setRotate(convertRotate(game.getBoard().getDistrict(1,1).getOrientation()));

        this.button06.getStyleClass().add(game.getBoard().getDistrict(1, 2).getCharacter().getName());
        this.button06.setRotate(convertRotate(game.getBoard().getDistrict(1,2).getOrientation()));

        this.button07.getStyleClass().add(game.getBoard().getDistrict(2, 0).getCharacter().getName());
        this.button07.setRotate(convertRotate(game.getBoard().getDistrict(2,0).getOrientation()));

        this.button08.getStyleClass().add(game.getBoard().getDistrict(2, 1).getCharacter().getName());
        this.button08.setRotate(convertRotate(game.getBoard().getDistrict(2,1).getOrientation()));

        this.button09.getStyleClass().add(game.getBoard().getDistrict(2, 2).getCharacter().getName());
        this.button09.setRotate(convertRotate(game.getBoard().getDistrict(2,2).getOrientation()));
*/

        //-------------------------------------------------------------------------------------------------------

        this.buttonAct1.setDisable(false);
        this.buttonAct1.getStyleClass().add("ActionToken");

        this.buttonAct2.setDisable(false);
        this.buttonAct2.getStyleClass().add("ActionToken");

        this.buttonAct3.setDisable(false);
        this.buttonAct3.getStyleClass().add("ActionToken");

        this.buttonAct4.setDisable(false);
        this.buttonAct4.getStyleClass().add("ActionToken");


        this.buttonAct1.getStyleClass().add(game.getBoard().getActionToken(0).toString());
        this.buttonAct2.getStyleClass().add(game.getBoard().getActionToken(1).toString());
        this.buttonAct3.getStyleClass().add(game.getBoard().getActionToken(2).toString());
        this.buttonAct4.getStyleClass().add(game.getBoard().getActionToken(3).toString());

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
        //exécute cette méthode en appuyant sur le bouton

        if ((Button)e.getSource() == buttonAct1){
            System.out.println("boutonAct1");
            String mrJackPointsString = ""+ game.getBoard().getMrJackPlayer().getCountHourglass();
            this.MrJackPoints.setText( mrJackPointsString );

            System.out.println(this.game.getBoard().getActionToken(0).toString());
            if (game.getBoard().getActionToken(0).toString().equals("Piocherunalibi")){
                if (this.isAlibisPrint){
                    System.out.println("Alibis"+game.getBoard().getAlibiCardDrawn().getName());
                this.buttonAfficherAlibi.getStyleClass().remove("Alibis"+game.getBoard().getAlibiCardDrawn().getName());
                }
                //System.out.println(game.getBoard().alibiDraw());

                game.getBoard().chooseActions(1);
                this.buttonAfficherAlibi.getStyleClass().add("Alibis"+game.getBoard().getAlibiCardDrawn().getName());
                //System.out.println(game.getBoard().alibiCardDrawed.getName());
                this.isAlibisPrint = true;

                this.buttonAct1.setDisable(true);
            }
        }
        if((Button)e.getSource() == buttonAct3){
            if(game.getBoard().getActionToken(2).toString().equals("Fairetournerunquartier1")){

                rotateButtonClicked = true;
                System.out.println(game.getBoard().getDistrict(0,0).getOrientation());
                game.getBoard().chooseActions(3);
                System.out.println(game.getBoard().getDistrict(0,0).getOrientation());


            }
        }

        if((Button)e.getSource() == buttonAct4){

            if(game.getBoard().getActionToken(2).toString().equals("Fairetournerunquartier1")){
                this.buttonAct1.setDisable(true);
                this.buttonAct2.setDisable(true);
                this.buttonAct4.setDisable(true);
                this.buttonAct3.setDisable(true);

                game.getBoard().chooseActions(3);

                this.buttonAct1.setDisable(false);
                this.buttonAct2.setDisable(false);
                this.buttonAct4.setDisable(false);


            }

        }

        //MISE A JOUR District
        int l = 0;
        for(int i = 0;i < 3;i++){
            for(int j = 0;j<3;j++) {

                if ((Button)e.getSource() == buttonAct3){
                    System.out.println("position " + game.getBoard().getDistrict(i,j).getOrientation() );
                    labelList.get(game.getBoard().getDistrictPosition()-1).setRotate(convertRotate(game.getBoard().getDistrict(i,j).getOrientation()));


                }

                if (!game.getBoard().getDistrict(i, j).isRecto()) {

                    System.out.println(game.getBoard().getDistrict(i,j).getCharacter().getName()+ " is returned");
                    labelList.get(l).getStyleClass().remove(game.getBoard().getDistrict(i, j).getCharacter().getName());
                    labelList.get(l).getStyleClass().add("Verso");

                }
                l = l +1;

            }

        }
    }
    public void send(){
        send.setOnAction(e -> System.out.println(textField.getText()));
    }

    public void play(){
        game.play();
    }
}