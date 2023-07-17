public class Kunde extends Person{
    private String kundennummer= "";
    //Set Methoden
    public void setKundennummer(String kundennummer){
        this.kundennummer = kundennummer;
    }
    //Get Methoden
    public String getKundennummer(){
        return kundennummer;
    }

    @Override
    public String toString(){
        String s = getKundennummer() + ": " + "ID: " + getBuergerID() + ", Name: " + getName() + ", Nachname: " + getNachname();
        return s;
    }
    @Override
    public boolean equals(Object obj){

        Kunde k = (Kunde) obj; // Es ist benotigt, weil die Benutzer versuchen können, in mitarbeiter ArrayList kunde zu speichern.

        if (getBuergerID().equals(k.getBuergerID()) && getKundennummer().equals(k.getKundennummer())){
            return true;
        }
        return false;

    }

    //Konstruktormethoden, Wenn wie eine Konstruktor method schreiben, wird die Standard
    //Konstruktormethod nicht mehr akzeptiert. Wir sollen explizit die leere Konstruktor schreiben.

    //Man darf zwei Konstruktor, die gleiche Anzahl von Parametern haben, nicht schreiben.
    public Kunde(String buergerID){
        super(buergerID);
    }

    public Kunde(String buergerID, String kundennummer){
        super(buergerID);
        this.kundennummer = kundennummer;
    }

    public Kunde(String buergerID, String name, String nachname){
        super(buergerID, name, nachname);
    }

    public Kunde(String buergerID, String name, String nachname, String kundennummer){
        super(buergerID, name, nachname);
        this.kundennummer = kundennummer;
    }
}
