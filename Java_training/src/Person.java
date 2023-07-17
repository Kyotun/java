import java.util.ArrayList;

public abstract class Person {
    private String name = "";
    private String nachname= "";
    private String buergerID= "";
    private int alter = 0;


    //Set Methoden
    public void setName(String name){
        if (Name_kontroller(name)){
            this.name = name;
        } else{

        }
    }
    public void setNachname(String nachname){
        if (Name_kontroller(nachname)) {
            this.nachname = nachname;
        }
    }
    public void setBuergerID(String buergerID) {
        if(ID_kontroller(buergerID)){
            this.buergerID = buergerID;
        } else{
            throw new BadBuergerIDFormat("BuergerID kann nicht mit 0 anfangen und nur aus 11-stellig sein.");
        }
    }
    public void setAlter(int alter){
        if (alter >=0 && alter <= 120) {
            this.alter = alter;
        }
    }
    //Get Methoden
    public int getAlter() {
        return alter;
    }
    public String getName(){
        return name;
    }
    public String getNachname(){
        return nachname;
    }
    public String getBuergerID(){
        return buergerID;
    }

    //Klassenmethoden

    @Override
    public boolean equals(Object obj){

        Person p = (Person) obj; // Es ist benotigt, weil die Benutzer versuchen können, in mitarbeiter ArrayList kunde zu speichern.

        if (getBuergerID().equals(p.getBuergerID())){
            return true;
        }
        return false;

    }
    public void printInfo(){
        System.out.println("name: " + getName());
        System.out.println("nachname: " + getNachname());
        System.out.println("id: " + getBuergerID());
     }
    public static boolean ID_kontroller(String id){
        if(id.charAt(0) != '0' && Character.isDigit(id.charAt(0)) && Character.isDigit(id.charAt(1)) && Character.isDigit(id.charAt(2)) && Character.isDigit(id.charAt(3))
                && Character.isDigit(id.charAt(4)) && Character.isDigit(id.charAt(5)) && Character.isDigit(id.charAt(6)) && Character.isDigit(id.charAt(7)) &&
                Character.isDigit(id.charAt(8)) && Character.isDigit(id.charAt(9)) && Character.isDigit(id.charAt(10))){
            return true;
        } else {
            return false;
        }

    }

    public static boolean Name_kontroller(String n){
        //Eine Funktion, die das Zeichen kontrolliert, ob es in Alphabet ist und die Leange dieses String großer als 2 ist.
        int l = n.length();
        if(l > 2){
            for(int i = 0; i < l; i++){
                char p = n.charAt(i);
                if ( p == ' ' || p == '.' || (p <= 90 && p >= 65) || (p <= 122 && p >= 97) ){
                } else {
                    System.out.println("Name kann nur aus Ziffern, Leerzeichen und Punkt bestehen.");
                    return false;
                }
            }
            return true;
        } else{
            System.out.println("Name solle eine Leange von mindestens 2 besitzen.");
            return false;
        }
    }

    //Die gegebene ArrayList soll eine Subklasse von ArrayList<Person> sein.
    public static void printSize(ArrayList<? extends Person> list){
        System.out.println(list.size());
    }

    //Konstruktormethoden
    public Person(String buergerID){
        this.buergerID = buergerID;
    }

    public Person(String buergerID, String name){
        this(buergerID);
        this.name = name;
    }
    public Person(String buergerID, String name, String nachname){
        this(buergerID, name);
        this.nachname = nachname;
    }

    public void setPersonenDaten(String buergerID, String name, String nachname, int alter){
        this.buergerID = buergerID;
        this.name = name;
        this.nachname = nachname;
        this.alter = alter;
    }

}
