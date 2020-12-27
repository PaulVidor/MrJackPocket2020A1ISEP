import javax.swing.*;
import java.awt.*;

public class District extends JComponent {
    private Orientation orientation;
    private Alibi character;
    private boolean isRecto;
    private boolean isJack;
    private boolean isCross;

    public District(Orientation orientation, Alibi character) {
        this.orientation = orientation;
        this.character = character;
        this.isRecto = true;
        this.isJack = false;
        //à voir si vraiment utile
        this.isCross = false;
    }

    public Alibi getCharacter() {
        return character;
    }

    public void isJack () {
        isJack = true;
    }

    public void isCross () {
        isCross = true;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public boolean isRecto() {
        return isRecto;
    }

    public void isVerso () {
        isRecto = false;
    }

    public String toString(String[] toPrint, Orientation orientation) {
        int indexOfOrientation = java.util.Arrays.asList(Orientation.values()).indexOf(orientation);
        String districtAffichage = toPrint[indexOfOrientation];
        return districtAffichage;
    }

    public boolean getIsJack() {
        return isJack;
    }
    // POUR TEST

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    //POUR TEST


}