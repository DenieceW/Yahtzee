package com.miniopdrachtenqien;

import java.util.Random;

public class Dobbelsteen {
    int aantalOgen;

    int werpen(){ //geeft 1 random getal terug
        Random random = new Random();
       return this.aantalOgen = random.nextInt(6) + 1;
    }

}
