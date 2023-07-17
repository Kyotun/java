public class Reisepaket {
    // Objekteattributen
    private String PaketID = "";
    private String Destination = "";
    private String Datum = "";
    private int Dauer = 0;
    private float Preis = 0;

    // Set Methoden
    public void setPaketID(String paketid) { this.PaketID = paketid; }
    public void setDestination(String destination){
        this.Destination = destination;
    }
    public void setDatum(String datum){
        this.Datum = datum;
    }
    public void setDauer(int dauer){
        this.Dauer = dauer;
    }
    public void setPreis(float preis){
        this.Preis = preis;
    }

    //Get Methoden
    public String getPaketID(){
        return this.PaketID;
    }
    public String getDestination(){
        return this.Destination;
    }
    public String getDatum(){
        return this.Datum;
    }
    public int getDauer(){
        return this.Dauer;
    }
    public float getPreis(){
        return this.Preis;
    }


    //Konstuktormethoden
    public Reisepaket(String pktid){
        this.PaketID = pktid;
    }

    public Reisepaket (String pktid, String dest, String dtm, int dauer, float prs){
        this(pktid);
        this.Destination = dest;
        this.Datum = dtm;
        this.Dauer = dauer;
        this.Preis = prs;
    }

    //Override

    public String toString() {
        String s = "ID: " + getPaketID() + ", Destination: " + getDestination() + ", Datum: " + getDatum() + ", Dauer: " + getDauer() + ", Preis: " + getPreis();
        return s;
    }

    public boolean equals(Object obj) {

        if (obj instanceof Reisepaket){
            Reisepaket r = (Reisepaket) obj;

            //erste BuergerID für, welche Obj diese Funktion aufruft?
            if (getPaketID().equals(r.getPaketID())){
                return true;
            } else {
                return false;
            }
        } return false;
    }


}
