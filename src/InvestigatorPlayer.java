import java.util.ArrayList;

public class InvestigatorPlayer extends Player{

    public InvestigatorPlayer(ArrayList<Alibi> alibiCards, int countHourglass, String name) {
        super(alibiCards, countHourglass, name);
    }

    @Override
    public ArrayList getAlibiCards() {
        return super.getAlibiCards();
    }
    @Override
    public void addToAlibiCards(Alibi alibiCard) {
        super.addToAlibiCards(alibiCard);
    }

    @Override
    public int getCountHourglass() {
        return super.getCountHourglass();
    }

    @Override
    public void addToCountHourglass(int countHourglass) {
        super.addToCountHourglass(countHourglass);
    }

    @Override
    public boolean hasReachObjective() {
        return super.hasReachObjective();
    }
}