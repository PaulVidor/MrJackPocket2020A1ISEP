package com.vidorpaul;
import javax.swing.JFrame;

public class GraphicInterface {
    public GraphicInterface() {
        super ("youpi");
        maFenetre.setSize(400, 300);
        maFenetre.setTitle("Plateau de jeu");
        //maFenetre.setLocation(100, 100);
    }

    MaFenetre maFenetre = new MaFenetre();

    public void name() {
    }
    maFenetre.setVisible(true);

}
}
