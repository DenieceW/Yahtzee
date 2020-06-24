package com.miniopdrachtenqien;


import java.util.ArrayList;
import java.util.Scanner;

public class YahtzeeSpel {
    ArrayList<Speler> spelerArrayList = new ArrayList<Speler>();
    Worp worp = new Worp();
    Scanner scanner = new Scanner(System.in);
    
    void spelen(){
        worp.getDobbelstenen();
        System.out.println("Gooi de dobbelstenen, druk 'ENTER'");
        scanner.nextLine();

        //beginnen met de allereerste worp
        worp.printRonde();
        worp.gooiDobbelstenen();
        worp.toonWorp();

        while(true){
            System.out.println("Welke posities wil je vasthouden? Vul de posities in of druk ENTER als je niks wil vasthouden");
            System.out.print("INVOER: ");
            invoer=scanner.nextLine();
            if(invoer.equals("q")){
                break;
            }
            if(invoer.equals("0")){ //als invoer leeg is, dan weer opnieuw dobbelstenen gooien met random getallen
                worp.printRonde();
                worp.gooiDobbelstenen();
                worp.toonWorp();

            }else
                worp.vasthouden(invoer); //als invoer niet leeg is, dan de dobbelstenen vasthouden op de positie van de ingevoerde nummers
                worp.printRonde();
                worp.opnieuwGooien(); //hier wordt opnieuw gegooid, exclusief de dobbelstenen die vast zitten
                worp.toonWorp();
    
                worp.rondes++;
        }
    }
}
