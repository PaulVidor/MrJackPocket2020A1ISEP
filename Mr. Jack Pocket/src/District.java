public class District {
    private Orientation orientation;
    private Alibi character;
    private boolean isRecto;
    private boolean isCross;

    public District(Orientation orientation, Alibi character, boolean isRecto, boolean isCross) {
        this.orientation = orientation;
        this.character = character;
        this.isRecto = isRecto;
        this.isCross = isCross;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public Alibi getCharacter() {
        return character;
    }

    public boolean isRecto() {
        return isRecto;
    }

    public boolean isCross() {
        return isCross;
    }
}
