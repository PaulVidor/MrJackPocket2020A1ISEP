public class District {
    private Orientation orientation;
    private Alibi character;
    private boolean isRecto;
    private boolean isVisible;
    private boolean isJack;
    private boolean isCross;

    public District(Orientation orientation, Alibi character) {
        this.orientation = orientation;
        this.character = character;
        this.isRecto = true;
        this.isVisible = false;
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

    public Orientation getOrientation() {
        return orientation;
    }

    public void isVisible () {
        isVisible = true;
    }

    // POUR TEST
    public boolean getIsJack() {
        return isJack;
    }

    //POUR TEST
}