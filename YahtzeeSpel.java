package com.miniopdrachtenqien;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class YahtzeeSpel {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Dobbelsteen> dobbelstenen = new ArrayList<Dobbelsteen>();
    Speler speler = new Speler();
    Worp worp = new Worp();
    char[] tempArray = new char[5];
    int[] blokkeerArray = {0,0,0,0,0};
    int rondes = 1;


    YahtzeeSpel(){
        for(int i = 0; i < 5; i++){
            dobbelstenen.add(new Dobbelsteen());
        }
    }

    void spelen(){
        System.out.println("Gooi de dobbelstenen");
        String invoer = scanner.nextLine();
        //beginnen met de allereerste worp
        System.out.println("WORP " + rondes);
        gooiDobbelstenen();
        printDobbelstenen();

        while(true){
            System.out.println("Welke posities wil je vasthouden? Vul de posities in of druk ENTER als je niks wil vasthouden");
            System.out.print("INVOER: ");
            invoer=scanner.nextLine();
            if(invoer.equals("q")){
                break;
            }
            if(invoer.equals("0")){ //als invoer leeg is, dan weer opnieuw dobbelstenen gooien met random getallen
                System.out.println("WORP " + rondes);
                gooiDobbelstenen();
                printDobbelstenen();
            }else
                vasthouden(invoer); //als invoer niet leeg is, dan de dobbelstenen vasthouden die de ingevoerde nummers
                System.out.println("");
                System.out.println("WORP " + rondes);
                opnieuwGooien(); //hier wordt opnieuw gegooid, exclusief de dobbelstenen die vast zitten
                Arrays.fill(blokkeerArray, 0); //blokkeerarray weer vullen met 0, zodat de vorige posities niet meegenomen worden.
        }
        speler.toonWorpen();
        System.out.println(speler.worpGeschiedenis.size());

    }

    int[] gooiDobbelstenen(){
        for (int i = 0; i < dobbelstenen.size(); i++){
            dobbelstenen.get(i).werpen();
            worp.uitslagWorp[i] = dobbelstenen.get(i).werpen();
        }
        rondes++;
        speler.worpGeschiedenis.add(worp);
        return worp.uitslagWorp;
    }

    void printDobbelstenen() {
        printNummers();
        worp.worp();
    }

    int[] vasthouden(String invoer){ //Dankzij Fien:-)
        tempArray = invoer.toCharArray();

        for (char c : tempArray) {
            blokkeerArray[Character.getNumericValue(c) - 1] = 1;
        }
        return blokkeerArray;
    }

    void opnieuwGooien(){
        for(int i = 0; i < dobbelstenen.size(); i++){
            if(blokkeerArray[i] == 0){
                worp.uitslagWorp[i] = dobbelstenen.get(i).werpen();
            }
        }
        rondes++;
        printDobbelstenen();
    }

    void printNummers(){
        for(int i = 1; i <= 5; i++){
            System.out.print(i + " ");
        }
        System.out.println("");
    }
}
