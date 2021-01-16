package com.thipasa.mrjack.ui;

import javafx.scene.control.Button;

import java.util.ArrayList;

public class Event {
    //Création d'une class Event qui recueille toutes les méthodes importantes.

    public void MakeNButton(ArrayList<Button> buttonList,int buttonNumber) {

        for(int i = 0; i< buttonNumber; i++){
            buttonList.add(new Button());
        }

    }

    public void setButtonDisable(ArrayList<Button> buttonList){
        int a = buttonList.size();


        for (int i = 0; i<a;i++){
            buttonList.get(i).setDisable(true);
        }

    }
    public void setButtonPicture(ArrayList<Button> buttonList){
        int a = buttonList.size();

        for (Integer i = 0; i<a;i++){

            String number = i.toString() ;
            buttonList.get(i).getStyleClass().add("Alibi"+number);
            System.out.println("Alibi"+number);
        }

    }



}
