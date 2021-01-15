package com.thipasa.mrjack.model;

public class District {
    private Orientation orientation;
    private final Alibi character;
    private boolean isRecto;
    private boolean isInSight;
    private boolean isJack;
    private boolean isCross;
    private boolean hasBeenRotate;

    public District(Orientation orientation, Alibi character) {
        this.orientation = orientation;
        this.character = character;
        this.isRecto = true;
        this.isInSight = false;
        this.isJack = false;
        this.isCross = false;
        this.hasBeenRotate = false;
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

    public boolean getIsCross() {
        return isCross;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public boolean isRecto() {
        return isRecto;
    }

    public void setVerso() {
        isRecto = false;
    }

    public void setInSight(boolean inSight) {
        isInSight = inSight;
    }

    public boolean isInSight() {
        return isInSight;
    }

    public boolean isHasBeenRotate() {
        return hasBeenRotate;
    }

    public void setHasBeenRotate() {
        this.hasBeenRotate = true;
    }


    public String toString(String[] toPrint, Orientation orientation) {
        int indexOfOrientation = java.util.Arrays.asList(Orientation.values()).indexOf(orientation);
        String districtAffichage = toPrint[indexOfOrientation];
        return districtAffichage;
    }

    public boolean getIsJack() {
        return isJack;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }
}