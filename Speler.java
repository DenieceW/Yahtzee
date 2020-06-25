package com.miniopdrachtenqien;

import java.util.ArrayList;
import java.util.Arrays;

public class Speler {
    Worp worp;
    ArrayList<Worp> worpGeschiedenis;
    String naam;

    Speler(String naam){
        this.worp = new Worp();
        worpGeschiedenis = new ArrayList<Worp>();
        this.naam = naam;

    }

    String getNaam(){
        return this.naam;
    }

    void addWorp(Worp worp){
        worpGeschiedenis.add(worp);
    }

    void toonWorpGeschiedenis(){
        for(Worp worp : worpGeschiedenis){
            System.out.println(Arrays.toString(worp.getUitslagWorp()));
        }
    }

}


