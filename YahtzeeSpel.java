package com.miniopdrachtenqien;


import java.util.ArrayList;

public class YahtzeeSpel {
    ArrayList<Speler> spelerArrayList = new ArrayList<Speler>();

    void addSpelers(){
        spelerArrayList.add(new Speler());
        spelerArrayList.add(new Speler());
    }
    void gameOn(){
        for(Speler speler: spelerArrayList){
            speler.worp.spelen();
        }
    }
}
