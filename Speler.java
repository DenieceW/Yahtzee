package com.miniopdrachtenqien;

import java.util.ArrayList;

public class Speler {
    ArrayList<Worp> worpGeschiedenis = new ArrayList<Worp>();
    Worp worp = new Worp();


    void addWorp(Worp worp){
        worpGeschiedenis.add(worp);
    }

    void toonWorpen(){
        for (Worp worp : worpGeschiedenis){
            worp.toonWorp();
        }
    }
}


