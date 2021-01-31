package com.thipasa.mrjack.players;

import com.thipasa.mrjack.model.Alibi;

import java.util.ArrayList;

public class InvestigatorPlayer extends Player {

    public InvestigatorPlayer(ArrayList<Alibi> alibiCards, String name) {
        super(alibiCards, name);
    }

    @Override
    public ArrayList<Alibi> getAlibiCards() {
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
    public String getName() {
        return super.getName();
    }

    @Override
    public boolean isHasReachObjective() {
        return super.isHasReachObjective();
    }

    @Override
    public void setHasReachObjective() {
        super.setHasReachObjective();
    }
}
