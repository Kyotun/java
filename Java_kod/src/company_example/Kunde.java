import java.util.ArrayList;

public class Kunde extends Person {
    //Objekteattributen
    private String kundennummer;
    private ArrayList<Reisepaket> Kunden_Pakete = new ArrayList<Reisepaket>();

    // Get&Set
    public void setKundenNummer(String kundennummer) {
        this.kundennummer = kundennummer;
    }

    public String getKundenNummer() {
        return this.kundennummer;
    }

    public void addPaket(Reisepaket paket){
        Kunden_Pakete.add(paket);
    }
    public void getPaket(){
        for (int j = 0; j < Kunden_Pakete.size(); j++) {
            System.out.println(Kunden_Pakete.get(j));
        }
    }

    //Override
    public String toString() {
        String s = getKundenNummer() + ": " + getBuergerID() + ", " + getName() + ", " + getNachName();
        return s;
    }

    public boolean equals(Object obj) {

        if (obj instanceof Kunde){
            Kunde k = (Kunde) obj;
            //erste BuergerID für, welche Obj diese Funktion aufruft?
            if (getKundenNummer().equals(k.getKundenNummer())){
                return true;
            } else {
                return false;
            }
        } return false;
    }


    public void printInfo() {
        System.out.println("name: " + getName());
        System.out.println("nachame: " + getNachName());
        System.out.println("buerger id: " + getBuergerID());
        System.out.println("alter: " + getAlter());
    }

    // Konstruktorfunktionen
    public Kunde(String buergerid){
        super(buergerid);
    }
    public Kunde(String buergerid, String kundennummer){
        super(buergerid);
        this.kundennummer = kundennummer;
    }
    public Kunde(String buergerid, String name, String nachname) {
        super(buergerid, name, nachname);
    }
    public Kunde(String buergerid, String name, String nachname, String kundennummer) {
        super(buergerid, name, nachname);// Personalnummer ist besonders
        this.kundennummer = "K" + kundennummer;
    }
}