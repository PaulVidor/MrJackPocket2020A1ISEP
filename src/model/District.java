package model;

public class District {
    private Orientation orientation;
    private final Alibi character;
    private boolean isRecto;
    private boolean isInSight;
    private boolean isCross;
    private boolean hasBeenRotate;

    public District(Orientation orientation, Alibi character) {
        this.orientation = orientation;
        this.character = character;
        this.isRecto = true;
        this.isInSight = false;
        this.isCross = false;
        this.hasBeenRotate = false;
    }

    public Alibi getCharacter() {
        return character;
    }

    public boolean getIsCross() {
        return isCross;
    }

    public void isCross () {
        isCross = true;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public boolean isRecto() {
        return isRecto;
    }

    public void setVerso() {
        isRecto = false;
    }

    public boolean isInSight() {
        return isInSight;
    }

    public void setInSight(boolean inSight) {
        isInSight = inSight;
    }

    public boolean HasBeenRotate() {
        return hasBeenRotate;
    }

    public void setHasBeenRotate(boolean hasBeenRotate) {
        this.hasBeenRotate=hasBeenRotate;
    }

    public String toString(String[] toPrint, Orientation orientation) {
        int indexOfOrientation = java.util.Arrays.asList(Orientation.values()).indexOf(orientation);
        return toPrint[indexOfOrientation];
    }
}