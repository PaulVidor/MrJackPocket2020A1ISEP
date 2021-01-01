import java.util.ArrayList;

public abstract class Player {
    public ArrayList<Alibi> alibiCards;
    public int countHourglass;
    public String name;

    public Player(ArrayList alibiCards, int countHourglass, String name) {
        this.alibiCards = alibiCards;
        this.countHourglass = 0;
        this.name = name;
    }

    public ArrayList getAlibiCards() {
        return alibiCards;
    }

    public void addToAlibiCards(Alibi alibiCard) {
        this.alibiCards.add(alibiCard);
    }

    public int getCountHourglass() {
        return countHourglass;
    }

    public void addToCountHourglass(int countHourglass) {
        this.countHourglass += countHourglass;
    }

    public boolean hasReachObjective() {
        return false;
    }
}


