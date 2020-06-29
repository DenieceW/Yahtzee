package com.miniopdrachtenqien;

import java.util.ArrayList;
import java.util.Arrays;

public class Speler {
    private Worp worp;
    private ArrayList<Worp> worpGeschiedenis;
    private String naam;

    Speler(String naam){
        this.worp = new Worp();
        this.worpGeschiedenis = new ArrayList<Worp>();
        this.naam = naam;

    }

    String getNaam(){
        return this.naam;
    }

    void addWorp(Worp worp){
        this.worpGeschiedenis.add(worp);
    }

    void toonWorpGeschiedenis(){
        System.out.println("Worpgeschiedenis: ");
        for(Worp worp : this.worpGeschiedenis){
            System.out.println(Arrays.toString(worp.getUitslagWorp()));
        }
    }

}


