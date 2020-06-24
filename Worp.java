package com.miniopdrachtenqien;

import java.util.ArrayList;
import java.util.Arrays;


public class Worp {
    ArrayList<Dobbelsteen> dobbelstenen = new ArrayList<Dobbelsteen>();
    int[] uitslagWorp = new int[5];
    int[] blokkeerArray = {0,0,0,0,0};
    char[] tempArray = new char[5];
    int rondes = 1;
    
    void printRonde(){
        System.out.println("WORP " + rondes);
    }

    void getDobbelstenen(){
        for(int i = 0; i < 5; i++){
            dobbelstenen.add(new Dobbelsteen());
        }
    }

    int[] gooiDobbelstenen(){
        for (int i = 0; i < dobbelstenen.size(); i++){
            dobbelstenen.get(i).werpen();
            uitslagWorp[i] = dobbelstenen.get(i).werpen();
        }
        rondes++;
        return uitslagWorp;
    }

    int[] vasthouden(String invoer){ //Dankzij Fien:-)
        tempArray = invoer.toCharArray();
        for (char c : tempArray) {
            blokkeerArray[Character.getNumericValue(c) - 1] = 1;
        }
        return blokkeerArray;
    }

    int[] opnieuwGooien(){
        for(int i = 0; i < dobbelstenen.size(); i++){
            if(blokkeerArray[i] == 0){
                uitslagWorp[i] = dobbelstenen.get(i).werpen();
            }
        }
        Arrays.fill(blokkeerArray, 0); //blokkeerarray weer vullen met 0, zodat de vorige posities niet meegenomen worden.
        return uitslagWorp;
    }

    void toonWorp(){
        for(int i = 1; i <= 5; i++){ //prints de posities van de dobbelstenen 1 t/m 5
            System.out.print(i + " ");
        }
        System.out.println("");

        for (int i : uitslagWorp){
            System.out.print(i + " ");
        }
        System.out.println(" ");
    }

}
