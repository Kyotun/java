import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        ArrayList<Mitarbeiter> mitarbeiter = new ArrayList<Mitarbeiter>();
        ArrayList<Kunde> kunden = new ArrayList<Kunde>();

        Scanner sc = new Scanner(System.in);

        int option = 0;
        int m_zeahler = 0;
        int k_zeahler = 0;

        while (option != 100) {

            option = 0;

            System.out.println("Weahlen Sie eine Option aus");
            System.out.println("1- Mitarbeiter hinzufuegen.");
            System.out.println("2- Alle Mitarbeiter auflisten.");
            System.out.println("3- Mitarbeiter aussuchen.");
            System.out.println("4- Kunde hinzufuegen.");
            System.out.println("5- Alle Kunde auflisten.");
            System.out.println("6- Kunde aussuchen");
            System.out.println("7- Reisepaket hinzufuegen");
            System.out.println("8- Alle Reisepakets auflisten");
            System.out.println("9- Reisepaket aussuchen");
            System.out.println("10- Reisepaketspreis aendern");
            System.out.println("11- ");
            System.out.println("12- ");
            System.out.println("13- ");
            System.out.println("100- Program beenden.");

            try{
                option = sc.nextInt(); sc.nextLine();

                if (option == 1) {
                    System.out.println("Geben Sie die 11 stellige BuergerID ein: ");
                    String id = sc.nextLine();

                    if (id.length() == 11) {
                        if (Person.ID_kontroller(id)) {
                            System.out.println("Geben Sie ihren Namen ein: ");
                            String n = sc.nextLine();
                            if(Person.Name_kontroller(n)){
                                System.out.println("Geben Sie ihren Nachnamen ein: ");
                                String nn = sc.nextLine();
                                if(Person.Name_kontroller(nn)){

                                    Mitarbeiter m = new Mitarbeiter(id, n, nn, "M" + String.valueOf(mitarbeiter.size()));
                                    mitarbeiter.add(m);
                                }
                            }
                        }
                    }

                } else if (option == 2) {
                    for(int i = 0; i < mitarbeiter.size(); i++){
                        System.out.println(mitarbeiter.get(i));
                    }

                } else if (option == 3) {
                    System.out.println("Geben Sie Ihre BuergerID ein: ");
                    String id = sc.nextLine();

                    System.out.println("Geben Sie Ihre Arbeiternummer ein: ");
                    String nm = sc.nextLine();

                    Mitarbeiter m_suche = new Mitarbeiter(id, nm);
                    //mitarbeiter.indexOf(obje) = mitarbeiter arraylistesine git index index gez, "obje"yle esdeger olan bir obje gelirse o objenin indexini return eder
                    int index = mitarbeiter.indexOf(m_suche);

                    if(index == -1){
                        System.out.println("Mitarbeiter konnte nicht gefunden werden.");
                    } else {
                        System.out.println(mitarbeiter.get(index));
                    }
                } else if (option == 4) {
                    System.out.println("Geben Sie die 11 stellige BuergerID ein: ");
                    String id = sc.nextLine();

                    if (id.length() == 11) {
                        if (Person.ID_kontroller(id)) {
                            System.out.println("Geben Sie ihren Namen ein: ");
                            String n = sc.nextLine();
                            if(Person.Name_kontroller(n)){
                                System.out.println("Geben Sie ihren Nachnamen ein: ");
                                String nn = sc.nextLine();

                                if(Person.Name_kontroller(nn)){
                                    Kunde k = new Kunde(id, n, nn, "K" + String.valueOf(k_zeahler));
                                    kunden.add(k);;

                                }
                            } else{
                                System.out.println("Name ");
                            }
                        } else {
                            System.out.println("Erste Zahl darf 0 nicht sein und BuergerID soll aus Ziffern bestehen.");
                        }
                    } else {
                        System.out.println("BuergerID soll 11-stellig sein.");
                    }
                } else if (option == 5) {
                    for(int i = 0; i < kunden.size(); i++){
                        System.out.println(kunden.get(i));
                    }

                } else if (option == 6) {
                    System.out.println("Geben Sie Ihre BuergerID ein: ");
                    String id = sc.nextLine();

                    System.out.println("Geben Sie Ihre Arbeiternummer ein: ");
                    String nm = sc.nextLine();

                    Kunde k_suche = new Kunde(id, nm);

                    if(kunden.contains(k_suche)){
                        int index = kunden.indexOf(k_suche);
                        System.out.println(kunden.get(index));
                    } else {
                        System.out.println("Mitarbeiter konnte nicht gefunden werden.");
                    }

                } else if (option == 7) {

                } else if (option == 8) {

                } else if (option == 9) {

                } else if (option == 10) {

                } else if (option == 11) {

                } else if (option == 12) {

                } else if (option == 13) {

                }
            } catch (InputMismatchException ime){
                System.out.println("Bitte geben Sie nur eine Zahl ein. Fehler: " + ime);
                sc.nextLine();
            }
        }


    }
}
