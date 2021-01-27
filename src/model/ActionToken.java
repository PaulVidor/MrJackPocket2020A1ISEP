package model;

public enum ActionToken {
    JETON1("Piocher un alibi", "Deplacer Sherlock"),
    JETON2("Deplacer Tobby", "Deplacer Watson"),
    JETON3("Faire tourner un quartier", "Echanger deux quartiers"),
    JETON4("Faire tourner un quartier", "Deplacer un detective au choix");

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
