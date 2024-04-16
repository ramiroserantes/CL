package com.daarthy.types;

public enum SpecEnum {

    GEMOLOGIST("Gemologist"),
    FORESTRANGER("ForestRanger"),
    ASSASSIN("Assassin"),
    SOLDIER("Soldier"),
    ENGINEER("Engineer"),
    ARCHITECT("Architect"),
    ARCHER("Archer"),
    MERCENARY("Mercenary"),
    ARCHAEOLOGIST("Archaeologist"),
    LIBRARIAN("Librarian");

    private String specName;

    SpecEnum(String specName) {
        this.specName = specName;
    }

    public String getSpecName() {
        return specName;
    }
}
