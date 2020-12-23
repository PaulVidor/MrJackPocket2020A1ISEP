public enum Detective {
    WATSON("Watson", 3),
    SHERLOCK("Sherlock", 11),
    TOBBY("Tobby", 7);

    private String name;
    private int position;

    Detective(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void movePosition (int distance) {
        this.position = (position + distance);
        if (position > 11) {
            position = position - 11;
        }
    }
}