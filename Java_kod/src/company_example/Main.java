import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;

class Main {
    public static void main(String[] args) {


        //Arraylist Elements sollen uebereinstimmen
        ArrayList<Mitarbeiter> mitarbeiter = new ArrayList<Mitarbeiter>();
        ArrayList<Kunde> kunden = new ArrayList<Kunde>();
        ArrayList<Reisepaket> reisepakets = new ArrayList<Reisepaket>();

        Scanner sc = new Scanner(System.in);

        int operation = 0;

        boolean akzp = true;

        while (operation != 100) {

            operation = 0;
            System.out.println("Welche Operation moechten Sie durchfuehren?");
            System.out.println("  1- Mitarbeiter hinzufuegen");
            System.out.println("  2- Mitarbeiter auflisten");
            System.out.println("  3- Mitarbeiter ausuchen");
            System.out.println("  4- Kunde hinzufuegen");
            System.out.println("  5- Kunden auflisten");
            System.out.println("  6- Kunde ausuchen");

            System.out.println("  7- Reisepaket hinzufuegen");
            System.out.println("  8- Reisepakete auflisten");
            System.out.println("  9- Reisepaket aussuchen");
            System.out.println("  10- Reisepaketspreis aendern");
            System.out.println("  11- Mitarbeiternachname aendern");
            System.out.println("  12- Reisepaket an Kunden verkaufen");
            System.out.println("  13- Alle Reisepakete eines Kunden auflisten");


            System.out.println("  100- Programm beenden");

            try {
                operation = sc.nextInt(); sc.nextLine();

                if (operation == 1) {
                    System.out.println("Geben Sie ihr BuergerID ein: ");
                    String bg = sc.nextLine();

                    if (Person.BuergerIDValid(bg)) {
                        System.out.println("Geben Sie Ihren Namen ein: ");
                        String nm = sc.nextLine();

                        if (Person.nameKontroller(nm)) {
                            System.out.println("Geben Sie Ihren Nachnamen ein:");
                            String nn = sc.nextLine();

                            if (Person.checkNachName(nn)) {
                                Mitarbeiter m = new Mitarbeiter(bg, nm, nn, String.valueOf(mitarbeiter.size()));
                                System.out.println("Ihre Kundenummer: M" + mitarbeiter.size());
                                mitarbeiter.add(m);
                                System.out.println("Danke fürs Anpassen an Regeln! Die Person wurde gespeichert.");
                            }
                        }
                    }
                } else if (operation == 2) {
                    for (int i = 0; i < mitarbeiter.size(); i++) {
                        System.out.println(mitarbeiter.get(i));
                    }
                    System.out.println("Es gibt keinen gespeicherten Person mehr.");

                } else if (operation == 3) {
                    System.out.println("Geben Sie Ihre BuergerID ein.");
                    String bg = sc.nextLine();
                    System.out.println("Geben Sie Mitarbeiternummer ein.");
                    String mn = sc.nextLine();

                    Mitarbeiter m = new Mitarbeiter(bg, mn);

                    //indexOf, enthealt equals(), deswegen haben wir diese Method überschrieben.
                    int index = mitarbeiter.indexOf(m);

                    if (index == -1) {
                        System.out.println("Person konnte nicht gefunden werden.");
                    } else {
                        System.out.println(mitarbeiter.get(index));
                    }

                } else if (operation == 4) {
                    System.out.println("Geben Sie Ihren BuergerID ein:");
                    String bg = sc.nextLine();

                    if (Person.BuergerIDValid(bg)) {
                        System.out.println("Geben Sie Ihren Namen ein:");
                        String nm = sc.nextLine();

                        if (Person.checkName(nm)) {
                            System.out.println("Geben Sie Ihren Nachnamen ein:");
                            String nn = sc.nextLine();

                            if (Person.checkNachName(nn)) {
                                Kunde k = new Kunde(bg, nm, nn, String.valueOf(kunden.size()));
                                System.out.println("Ihre Kundenummer: K" + String.valueOf(kunden.size()));
                                kunden.add(k);
                                System.out.println("Danke fürs Anpassen an Regeln! Die Person wurde gespeichert.");

                            }
                        }
                    }
                } else if (operation == 5) {
                    for (int j = 0; j < kunden.size(); j++) {
                        System.out.println(kunden.get(j));
                    }
                    System.out.println("Es gibt keinen gespeicherten Person mehr.");

                } else if (operation == 6) {
                    System.out.println("Geben Sie Ihre BuergerID ein.");
                    String bg = sc.nextLine();
                    System.out.println("Geben Sie Mitarbeiternummer ein.");
                    String kn = sc.nextLine();

                    Kunde k = new Kunde(bg, kn);

                    //indexOf, enthealt equals(), deswegen haben wir diese Method überschrieben.
                    int index = kunden.indexOf(k);

                    if (index == -1) {
                        System.out.println("Person konnte nicht gefunden werden.");

                    } else {
                        System.out.println(kunden.get(index));
                    }

                } else if (operation == 7) {
                    System.out.println("Geben Sie bitte die PaketID ein: ");
                    String pktid = sc.nextLine();

                    System.out.println("Geben Sie bitte die Destination ein: ");
                    String dest = sc.nextLine();

                    System.out.println("Geben Sie bitte die Datum ein: ");
                    String datum = sc.nextLine();

                    System.out.println("Geben Sie bitte den Dauer ein: ");
                    int dauer = sc.nextInt();

                    System.out.println("Geben Sie bitte den Preis ein: ");
                    float preis = sc.nextFloat();

                    Reisepaket r = new Reisepaket(pktid, dest, datum, dauer, preis);
                    reisepakets.add(r);
                    System.out.println("Paket wurde hinzugefuegt. Es gibt " + reisepakets.size() + " Paket(s) in der Liste.");

                } else if (operation == 8) {
                    for (int i = 0; i < reisepakets.size(); i++) {
                        System.out.println(reisepakets.get(i));
                    }
                    System.out.println("Es gibt keine gespeicherten Reisepakets mehr.");

                } else if (operation == 9) {
                    System.out.println("Geben Sie PaketID ein: ");
                    String pktid = sc.nextLine();

                    Reisepaket r = new Reisepaket(pktid);

                    //indexOf, enthealt equals(), deswegen haben wir diese Method überschrieben.
                    int index = reisepakets.indexOf(r);

                    if (index == -1) {
                        System.out.println("Reisepaket konnte nicht gefunden werden.");

                    } else {
                        System.out.println(reisepakets.get(index));
                    }

                } else if (operation == 10) {
                    System.out.println("Geben Sie die PaketID ein: ");
                    String pktid = sc.nextLine();
                    Reisepaket r = new Reisepaket(pktid);

                    if (reisepakets.contains(r)) {
                        int index = reisepakets.indexOf(r);
                        Reisepaket r2 = reisepakets.get(index);
                        System.out.println("Bitte geben Sie neuen Preis ein: ");
                        float prs = sc.nextFloat();
                        r2.setPreis(prs);
                        System.out.println("Preis wurde geaendert.");
                    }

                } else if (operation == 11) {
                    System.out.println("Geben Sie Ihre BuergerID ein: ");
                    String bg = sc.nextLine();
                    System.out.println("Geben Sie Mitarbeiternummer ein.");
                    String kn = sc.nextLine();
                    Mitarbeiter m = new Mitarbeiter(bg, kn);

                    if (mitarbeiter.contains(m)) {
                        int index = mitarbeiter.indexOf(m); // Wenn es generisch waere, sollten wir Type-Casting machen.
                        Mitarbeiter m2 = mitarbeiter.get(index);
                        System.out.println("Bitte geben Sie den neuen Nachnamen ein:");
                        String nn = sc.nextLine();
                        m2.setNachName(nn);

                    } else {
                        System.out.println("Mitarbeiter konnte nicht gefunden werden.");
                    }

                } else if (operation == 12){ //Reisepaket an Kunden verkaufen
                    System.out.println("Geben Sie die BuergerID der Kunden ein: ");
                    String bg = sc.nextLine();

                    System.out.println("Geben Sie Kundennummer der Kunde ein: ");
                    String kn = sc.nextLine();

                    System.out.println("Geben Sie PaketID, den Sie einkaufen möchten: ");
                    String pktid = sc.nextLine();

                    int index = kunden.indexOf(new Kunde(bg, kn));

                    if(index >= 0){
                        Kunde temp_k = kunden.get(index);
                        index = reisepakets.indexOf(new Reisepaket((pktid)));
                        if (index >= 0){
                            Reisepaket rp = reisepakets.get(index);

                            temp_k.addPaket(rp);
                        } else {
                            System.out.println("Reisepaket konnte nicht gefunden werden.");
                        }
                    } else {
                        System.out.println("Kunde konnte nicht gefunden werden.");
                    }

                } else if (operation == 13) { // Alle Reisepakete eines Kunden auflisten
                    System.out.println("Geben Sie auch BuergerID dieser Kunde ein, der ausgesucht werden soll: ");
                    String bg = sc.nextLine();

                    System.out.println("Geben Sie Kundennummer ein, der ausgesucht werden soll: ");
                    String kn = sc.nextLine();

                    Kunde kunde = new Kunde(bg, kn);

                    int index = kunden.indexOf(kunde);

                    if (index == -1) {
                        System.out.println("Person konnte nicht gefunden werden.");

                    } else {
                        Kunde knd = kunden.get(index);
                        knd.getPaket();
                    }


                }else if (operation == 100) {
                    System.out.println("Bis speater!");

                }
            }
            catch (InputMismatchException ime) {
                System.out.println("Error:" + ime + ". Bitte geben Sie eine Zahl ein.");
                sc.nextLine();

            } catch (BadBuergerIDFormatException bbe) {
                System.out.println("Fehler:" + bbe);
                sc.nextLine();

            } catch (NameFormatException nfe) {
                System.out.println("Fehler:" + nfe);
                sc.nextLine();

            } catch (Exception excp) {
                System.out.println("Fehler:" + excp);
                sc.nextLine();

            }

        }
    }
}
