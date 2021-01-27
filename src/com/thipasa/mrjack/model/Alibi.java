package com.thipasa.mrjack.model;

public enum Alibi {
    PINK("Madame", 2),
    BLACK("Goodley", 0),
    ORANGE("Bert", 1),
    VIOLET("Gull", 1),
    GREEN("Stealthy", 1),
    YELLOW("Smith", 1),
    BLUE("Lestrade", 0),
    WHITE("Pizer", 1),
    BROWN("Lane", 1);


    private final String name;
    private final int hourglass;
    private District district;

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

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }
}