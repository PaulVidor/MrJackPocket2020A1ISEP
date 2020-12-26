public enum Orientation {
    NORTH(0),
    SOUTH(1),
    WEST(2),
    EAST(3);

    private int orientationToInt;

    Orientation(int orientationToInt) {
        this.orientationToInt = orientationToInt;
    }
}