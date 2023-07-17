public class Mitarbeiter extends Person{
    private String arbeiternummer = "";

    //Get Methoden
    public String getArbeiternummer(){
        return this.arbeiternummer;
    }

    //Set Methoden
    public void setArbeiternummer(String arbeiternummer){
        this.arbeiternummer = arbeiternummer;
    }

    @Override
    public String toString(){
        String s = getArbeiternummer() + ": " + "ID: " + getBuergerID() + ", Name: " + getName() + ", Nachname: " + getNachname();
        return s;
    }

    @Override
    public boolean equals(Object obj){

        Mitarbeiter m = (Mitarbeiter) obj; // Es ist benotigt, weil die Benutzer versuchen können, in mitarbeiter ArrayList kunde zu speichern.

        if (getBuergerID().equals(m.getBuergerID()) && getArbeiternummer().equals(m.getArbeiternummer())){
            return true;
        }
        return false;

    }

    //Konstruktormethoden
    public Mitarbeiter(String buergerID){
        super(buergerID);
    }

    public Mitarbeiter(String buergerID, String arbeiternummer) {
        super(buergerID);
        this.arbeiternummer = arbeiternummer;
    }

    public Mitarbeiter(String buergerID, String name, String nachname){
        super(buergerID, name, nachname);
    }

    public Mitarbeiter(String buergerID, String name, String nachname, String arbeiternummer){
        super(buergerID, name, nachname);
        this.arbeiternummer = arbeiternummer;
    }

}
