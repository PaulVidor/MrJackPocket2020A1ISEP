public enum Detectives {
    WATSON("Waston"),
    SHERLOCK("Sherlock"),
    TOBBY("Tobby");

    private String name;

    Detectives(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
