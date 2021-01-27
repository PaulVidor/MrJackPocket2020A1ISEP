package com.thipasa.mrjack.model;

public enum ActionToken {
    JETON1("Piocherunalibi", "DeplacerSherlock"),
    JETON2("DeplacerTobby", "DeplacerWatson"),
    JETON3("Fairetournerunquartier1", "Echangerdeuxquartiers"),
    JETON4("Fairetournerunquartier2", "Deplacerlestroisdetectives");

    private boolean isHead;
    private boolean hasBeenUsed;
    private final String nameHead;
    private final String nameTails;

    ActionToken(String nameHead, String nameTails) {
        this.isHead = true;
        this.hasBeenUsed = false;
        this.nameHead = nameHead;
        this.nameTails = nameTails;
    }

    public boolean isHead() {
        return isHead;
    }

    public boolean isHasBeenUsed() {
        return !hasBeenUsed;
    }

    public void setHead(boolean head) {
        isHead = head;
    }

    public void setHasBeenUsed(boolean hasBeenUsed) {
        this.hasBeenUsed = hasBeenUsed;
    }

    public String toString() {
        if (isHead) {
            return nameHead;
        } else {
            return nameTails;
        }
    }
}