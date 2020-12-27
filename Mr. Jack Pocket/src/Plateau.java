import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Plateau extends JComponent{
    ImageIcon imgInspLestraderecto, imgJeremyBertrecto, imgJohnPizerrecto, imgJohnSmithrecto,
            imgJosephLanerecto, imgMadamerector, imgMissStealthyrecto, imgSgtGoodleyrecto, imgWilliamGullrecto,
            imgSherlock, imgTobi, imgWatson;

    //tableau provisoir, faudra utiliser ton bout de code pour ça avec 1 - 2 ect pour différencier

    String[][] pieces = {
            {null, null, null, null, null},
            {"1imgSherlock", "2imgInspLestraderecto", "3imgJeremyBertrecto", "4imgJohnPizerrecto", "5imgWatson"},
            {null, "6imgJohnSmithrecto", "7imgJosephLanerecto", "8imgMadamerector", null},
            {null, "9imgMissStealthyrecto", "AimgSgtGoodleyrecto", "BimgWilliamGullrecto",null},
            {null, null, null, "CimgTobi", null},
    };

    Plateau(){
        imgInspLestraderecto = new ImageIcon(getClass().getResource("/pictures/districts/InspLestrade-recto.png"));
        imgJeremyBertrecto = new ImageIcon(getClass().getResource("/pictures/districts/JeremyBert-recto.png"));
        imgJohnPizerrecto = new ImageIcon(getClass().getResource("/pictures/districts/JohnPizer-recto.png"));
        imgJohnSmithrecto = new ImageIcon(getClass().getResource("/pictures/districts/JohnSmith-recto.png"));
        imgJosephLanerecto = new ImageIcon(getClass().getResource("/pictures/districts/JosephLane-recto.png"));
        imgMadamerector = new ImageIcon(getClass().getResource("/pictures/districts/Madame-rector.png"));
        imgMissStealthyrecto = new ImageIcon(getClass().getResource("/pictures/districts/MissStealthy-recto.png"));
        imgSgtGoodleyrecto = new ImageIcon(getClass().getResource("/pictures/districts/SgtGoodley-recto.png"));
        imgWilliamGullrecto = new ImageIcon(getClass().getResource("/pictures/districts/WilliamGull-recto.png"));
        imgSherlock = new ImageIcon(getClass().getResource("pictures/detectives/Sherlock.png"));
        imgTobi = new ImageIcon(getClass().getResource("pictures/detectives/Tobi.png"));
        imgWatson = new ImageIcon(getClass().getResource("pictures/detectives/Watson.png"));


    }

    protected void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;

        int CASE_DIM = 165;
        boolean isWhite = true;
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                if(isWhite){
                    g2.setPaint(Color.WHITE);
                }
                else{
                    g2.setPaint((Color.LIGHT_GRAY));
                }
                g2.fill(new Rectangle2D.Double((j+1)*CASE_DIM, (i+1)*CASE_DIM, CASE_DIM, CASE_DIM));
                isWhite = !isWhite; // alterner gris et blanc pour la lecture, j'ai hésité à mettre gris détectif et inv
            }
        }

        //Cadre autour pour faire beau (vive la vie)

        g2.setPaint(Color.DARK_GRAY);
        g2.setStroke(new BasicStroke(2));
        g2.draw(new Rectangle2D.Double(CASE_DIM, CASE_DIM, 5*CASE_DIM, 5*CASE_DIM));


        // Les pièces de manière arbitraire

        ImageIcon img = null;

        for (int i = 0; i < 5; i++){
            for (int j = 0; j < 5; j++){
                if (pieces[i][j] != null){
                    if (pieces[i][j].charAt(0) == '1'){  // pas changer lui
                        img = imgSherlock;
                    }
                    else if (pieces[i][j].charAt(0) == '2'){
                        img = imgInspLestraderecto;
                    }
                    else if (pieces[i][j].charAt(0) == '3'){
                        img = imgJeremyBertrecto;
                    }
                    else if (pieces[i][j].charAt(0) == '4'){
                        img = imgJohnPizerrecto;
                    }
                    else if (pieces[i][j].charAt(0) == '5'){ // pas changer lui
                        img = imgWatson;
                    }
                    else if (pieces[i][j].charAt(0) == '6'){
                        img = imgJohnSmithrecto;
                    }
                    else if (pieces[i][j].charAt(0) == '7'){
                        img = imgJosephLanerecto;
                    }
                    else if (pieces[i][j].charAt(0) == '8'){
                        img = imgMadamerector;
                    }
                    else if (pieces[i][j].charAt(0) == '9'){
                        img = imgMissStealthyrecto;
                    }
                    else if (pieces[i][j].charAt(0) == 'A'){
                        img = imgSgtGoodleyrecto;
                    }
                    else if (pieces[i][j].charAt(0) == 'B'){
                        img = imgWilliamGullrecto;

                    }
                    else if (pieces[i][j].charAt(0) == 'C'){ // pas changer lui
                        img = imgTobi;
                    }
                    img.paintIcon(null, g2, (j+1)*CASE_DIM, (i+1)*CASE_DIM);
                }
            }
        }


        g2.dispose();
    }

}
