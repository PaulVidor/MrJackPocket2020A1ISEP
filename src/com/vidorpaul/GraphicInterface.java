package com.vidorpaul;
import javax.swing.JFrame;


public class GraphicInterface {
    public JFrame maFenetre;

    public GraphicInterface() {
        this.maFenetre = new JFrame();
        this.maFenetre.setSize(400, 300);
        this.maFenetre.setTitle("Plateau de jeu");
        this.maFenetre.setLocation(100, 100);
        this.maFenetre.setVisible(true);
        this.maFenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public JFrame getMaFenetre() {
        return this.maFenetre;
        //Permet de recupérer maFenetre
    }
}