package com.miniopdrachtenqien;

import java.util.ArrayList;
import java.util.Scanner;

public class YahtzeeSpel {
    ArrayList<Speler> spelerArrayList = new ArrayList<Speler>();
    Scanner scanner = new Scanner(System.in);
    int rondes = 1;
    boolean gameOn = true;

    void spelen() {
        setAantalSpelers();

        while (gameOn) {

                for (Speler speler : spelerArrayList) {
                    Worp worp = new Worp();
                    System.out.println(speler.getNaam() + " mag gaan dobbelen. Druk 'ENTER'");
                    String invoer = scanner.nextLine();
                    if(invoer.equals("q")){
                        gameOn = false;
                    }
                    if(invoer.isEmpty()){
                        printRonde();
                        worp.getDobbelstenen();
                        worp.gooiDobbelstenen();
                        worp.toonWorp();
                        System.out.println("Welke posities wil je vasthouden? Vul de posities in of druk ENTER als je niks wil vasthouden");
                        System.out.print("INVOER: ");
                        invoer = scanner.nextLine().trim();
                        worp.vasthouden(invoer); //als invoer niet leeg is, dan de dobbelstenen vasthouden op de positie van de ingevoerde nummers
                        printRonde();
                        worp.opnieuwGooien(); //hier wordt opnieuw gegooid, exclusief de dobbelstenen die vast zitten
                        worp.toonWorp();
                        speler.addWorp(worp); //hier wordt de worp opgeslagen
                        speler.toonWorpGeschiedenis(); //hier wordt de worpgeschiedenis getoond.
                    }
                }
                System.out.println(" ");
                System.out.println("Iedereen heeft " + rondes + " keer gedobbeld");
                System.out.println("---------------------------------------");
                rondes++;
        }
    }

    void printRonde(){
        System.out.println("WORP " + rondes);
    }

    void setAantalSpelers () {
        System.out.print("Kies het aantal spelers: ");
        int aantalSpelers = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < aantalSpelers; i++) {
            System.out.print("Naam speler: ");
            String name = scanner.nextLine();
            this.spelerArrayList.add(new Speler(name));
        }
    }
}