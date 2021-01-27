package players;

import model.Alibi;

import java.util.ArrayList;

public abstract class Player {
    public ArrayList<Alibi> alibiCards;
    public int countHourglass;
    public String name;
    public boolean hasReachObjective;

    public Player(ArrayList<Alibi> alibiCards, String name) {
        this.alibiCards = alibiCards;
        this.countHourglass = 0;
        this.name = name;
        this.hasReachObjective = false;
    }

    public ArrayList<Alibi> getAlibiCards() {
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

    public String getName() {
        return name;
    }

    public boolean isHasReachObjective() {
        return hasReachObjective;
    }

    public void setHasReachObjective() {
        hasReachObjective = true;
    }
}