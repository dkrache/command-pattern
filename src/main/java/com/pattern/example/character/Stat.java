package com.pattern.example.character;

public class Stat {
    private int attack;
    private int defense;

    public Stat(int attack, int defense){
        this.attack = attack;
        this.defense = defense;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }
}
