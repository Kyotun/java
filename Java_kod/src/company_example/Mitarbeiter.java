public class Mitarbeiter extends Person  {
    //Objekteattributen
    private String arbeiternummer;
    private String filiale; // Wo arbeite ich?
    private String abteilung; // Department

    // Get&Set Schritt
    public void setArbeiterNummer(String arbeiternummer) {
        this.arbeiternummer = arbeiternummer;
    }

    public String getArbeiterNummer() {
        return this.arbeiternummer;
    }

    public void setFiliale(String filiale) {
        this.filiale = filiale;
    }

    public String getFiliale() {
        return this.filiale;
    }

    public void setAbteilung(String abteilung) {
        this.abteilung = abteilung;
    }

    public String getAbteilung() {
        return this.abteilung;
    }

    //Override
    public String toString() {
        String s = getArbeiterNummer() + ": " + getBuergerID() + ", " + getName() + ", " + getNachName();
        return s;
    }

    public boolean equals(Object obj) {

        if (obj instanceof Mitarbeiter){
            Mitarbeiter m = (Mitarbeiter) obj;

            //erste BuergerID für, welche Obj diese Funktion aufruft?
            if (getArbeiterNummer().equals(m.getArbeiterNummer())){
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
        System.out.println("personalnummer: " + getArbeiterNummer());
    }

    // Konstruktorfunktionen
    public Mitarbeiter(String buergerid, String arbeiternummer){
        super(buergerid);
        this.arbeiternummer = arbeiternummer;
    }

    public Mitarbeiter(String buergerid, String name, String nachname) {
        super(buergerid, name, nachname);
    }

    public Mitarbeiter(String buergerid, String name, String nachname, String arbeiternummer) {
        super(buergerid, name, nachname);// Personalnummer ist besonders
        this.arbeiternummer = "M" + arbeiternummer;
    }
}