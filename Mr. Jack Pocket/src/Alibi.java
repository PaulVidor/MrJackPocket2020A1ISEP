public enum Alibi {
    ROSE("Madame",2),
    BLACK("Sgt Goodley",0),
    ORANGE("Jeremy Bert",1),
    VIOLET("William Gull",1),
    GREEN("Miss Stealthy",1),
    YELLOW("Jhon Smith",1),
    BLUE("Insp. Lestrade",0),
    WHITE("John Pizer",1),
    BROWN("Joseph Lane",1);


    private String name;
    private int hourglass;

    Alibi(String name, int hourglass) {
        this.name = name;
        this.hourglass = hourglass;
    }

    public int getHourglass() {
        return hourglass;
    }

    public String getName() {
        return name;
    }
}