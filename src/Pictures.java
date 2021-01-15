/*package sample;

public class Pictures {
    import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

    public class CodeGrille extends JPanel {

        public final static int NB_LIGNES = 10;
        public final static int NB_COLONNES = 10;

        private int[][] grid = new int[NB_LIGNES][NB_COLONNES];

        private Pictures[] images;

        public CodeGrille() {

            images = new Pictures[2];
            images[0] = lireImage("bleu.jpg"); // attention à la manière d'aller chercher ce fichier (ceci peut fonctionner ou pas selon l'emplacement du fichier) :
            images[1] = lireImage("vert.jpg");

            for (int i = 0; i < NB_LIGNES; i++) {
                for (int j = 0; j < NB_COLONNES; j++) {
                    grid[i][j] = (int) (Math.random() * images.length);
                }
            }
        }

        private Pictures lireImage(String string) {

            try {

                return ImageIO.read(new File(string));

            } catch (IOException e1) {
                e1.printStackTrace();
                return null;
            }

        }

    }
}
*/