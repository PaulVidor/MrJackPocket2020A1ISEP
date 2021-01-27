package com.thipasa.mrjack.players;

import com.thipasa.mrjack.model.Alibi;

import java.util.ArrayList;

public class MrJackPlayer extends Player {
    private final Alibi mrJackCharacter;

    public MrJackPlayer(ArrayList<Alibi> alibiCards, String name, Alibi mrJackCharacter) {
        super(alibiCards, name);
        this.mrJackCharacter = mrJackCharacter;
    }

    public String toString() {
        return mrJackCharacter.getName() + " (" + mrJackCharacter.toString().charAt(0)
                + mrJackCharacter.toString().charAt(1) + mrJackCharacter.toString().charAt(2) + ")";
    }

    @Override
    public int getCountHourglass() {
        return super.getCountHourglass();
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