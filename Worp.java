package com.miniopdrachtenqien;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Worp {
    int[] uitslagWorp = new int[5];
    ArrayList<Dobbelsteen> dobbelstenen = new ArrayList<Dobbelsteen>();
    char[] tempArray = new char[5];
    int[] blokkeerArray = {0,0,0,0,0};
    int rondes = 1;
    Scanner scanner = new Scanner(System.in);

    void spelen(){
        getDobbelstenen();
        System.out.println("Gooi de dobbelstenen, druk 'ENTER'");
        String invoer = scanner.nextLine();

        //beginnen met de allereerste worp
        printRonde();
        gooiDobbelstenen();
        toonWorp();

        while(true){
            System.out.println("Welke posities wil je vasthouden? Vul de posities in of druk ENTER als je niks wil vasthouden");
            System.out.print("INVOER: ");
            invoer=scanner.nextLine();
            if(invoer.equals("q")){
                break;
            }
            if(invoer.equals("0")){ //als invoer leeg is, dan weer opnieuw dobbelstenen gooien met random getallen
                printRonde();
                gooiDobbelstenen();
                toonWorp();

            }else
                vasthouden(invoer); //als invoer niet leeg is, dan de dobbelstenen vasthouden op de positie van de ingevoerde nummers
                printRonde();
                opnieuwGooien(); //hier wordt opnieuw gegooid, exclusief de dobbelstenen die vast zitten
                toonWorp();

            rondes++;
        }
    }

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
        printNummers();
        for (int i : uitslagWorp){
            System.out.print(i + " ");
        }
        System.out.println(" ");
    }

    void printNummers(){
        for(int i = 1; i <= 5; i++){
            System.out.print(i + " ");
        }
        System.out.println("");
    }
}
