package model;

public enum Detective {
    WATSON("Watson", 3),
    SHERLOCK("Sherlock", 11),
    TOBBY("Tobby", 7);

    private final String name;
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

    public void setPosition(int position) {
        this.position = position;
    }
}