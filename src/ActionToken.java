public enum ActionToken {
    JETON1,
    JETON2,
    JETON3,
    JETON4;

    private boolean isHead;
    private boolean isHoldByInvestigator;
    private boolean hasBeenUsed;

    ActionToken() {
        this.isHead = true;
        this.isHoldByInvestigator = true;
        this.hasBeenUsed = false;
    }

    public boolean isHead() {
        return isHead;
    }

    public boolean isHoldByInvestigator() {
        return isHoldByInvestigator;
    }

    public boolean isHasBeenUsed() {
        return hasBeenUsed;
    }

    public void setHead(boolean head) {
        isHead = head;
    }

    public void setHoldByInvestigator(boolean holdByInvestigator) {
        isHoldByInvestigator = holdByInvestigator;
    }

    public void setHasBeenUsed(boolean hasBeenUsed) {
        this.hasBeenUsed = hasBeenUsed;
    }
}
