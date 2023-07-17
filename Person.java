import java.util.ArrayList;
import java.util.regex.*;

public abstract class Person {
    // Objekteattributen
    private String buergerid;
    private int alter;
    private String name;
    private String nachname;
    private boolean authorisation;

    // Get&Set
    public void setName(String name) {
        if (checkName(name) == true) {
            this.name = name;
        }
    }

    public String getName() {
        return this.name;
    }

    public void setNachName(String nachname) throws NameFormatException {
        if (checkNachName(nachname) == true) {
            this.nachname = nachname;
        }
    }

    public String getNachName() {
        return this.nachname;
    }

    public void setBuergerID(String buergerid) throws BadBuergerIDFormatException{
        if (checkBuergerID(buergerid) == true) {
            this.buergerid = buergerid;
        } else {
            throw new BadBuergerIDFormatException("Prüfen Sie bitte Ihre BuergerID, ob es richtig ist.");
        }
    }

    public String getBuergerID() {
        return this.buergerid;
    }

    public void setAlter(int alter) {
        if (alter >= 0) {
            this.alter = alter;
        }
    }

    public int getAlter() {
        return this.alter;
    }

    public void setAut(boolean authorisation) {
        this.authorisation = authorisation;
    }

    public boolean getAut() {
        return this.authorisation;
    }

    // Konstruktorfunktionen
    public Person(String buergerid) {
        this.buergerid = buergerid;
    }

    public Person(String buergerid, String name, String nachname) {
        this(buergerid);
        this.name = name;
        this.nachname = nachname;
    }

    public Person(String buergerid, String name, String nachname, int alter) {
        this(buergerid, name, nachname);
        this.alter = alter;
    }

    public Person(String buergerid, String name, String nachname, int alter, boolean authorisation) {
        this(buergerid, name, nachname, alter);
        this.authorisation = authorisation;
    }

    // Klassenmethoden
    public static void printData(Person p) {
        System.out.println(p.getBuergerID() + ", " + p.getName() + ", " + p.getNachName());
    }

    public static void printSize(ArrayList<? extends Person> list){
        System.out.println(list.size());
    }

    // return int, -1 lenght, -2 icerik, 0 hatasiz
    public static boolean checkBuergerID(String bg)  throws BadBuergerIDFormatException{
        if (bg.length() == 7) {
            if (bg.length() != 0 && bg.charAt(0) != '0' && Character.isDigit(bg.charAt(0)) &&
                    Character.isDigit(bg.charAt(1)) && Character.isDigit(bg.charAt(2)) && Character.isDigit(bg.charAt(3)) &&
                    Character.isDigit(bg.charAt(4)) && Character.isDigit(bg.charAt(5)) && Character.isDigit(bg.charAt(6))) {
                return true;
            } else {
                throw new BadBuergerIDFormatException("BuergerID darf nur aus Ziffern bestehen.");
            }
        } else {
            throw new BadBuergerIDFormatException("BuergerID soll siebenstellig sein.");
        }
    }

    //
    public static boolean checkName(String n) throws NameFormatException{
        if (n.length() >= 2) {
            for (int i = 0; i < n.length(); i++) {
                if (Person.isLatinLetter(n.charAt(i)) || n.charAt(i) == ' ' || n.charAt(i) == '.') {
                    return true;
                } else {
                    throw new NameFormatException("Name darf nur Ledeneerzeichen, Punkt und lateinische Alphabet besitzen.");
                }
            }
            return false;
        } else {
            throw new NameFormatException("Name soll mindestens die Leange 2 besitzen.");
        }
    }

    public static boolean nameKontroller(String n){
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

    //
    public static boolean checkNachName(String nn) {
        if (nn.length() >= 2) {
            return true;
        } else {
            throw new NameFormatException("Nachname soll mindestens die Leange 2 besitzen.");
        }
    }

    public static int NummerGeber(String nummer) {
        String nummerstring = nummer.substring(0, 0) + nummer.substring(0 + 1);
        int nummerint = Integer.parseInt(nummerstring);
        return nummerint;
    }
    //Override
    public boolean equals (Object obj) {
        if (obj instanceof Person){
            Person p = (Person) obj;
            //erste BuergerID für, welche Obj diese Funktion aufruft?
            if (getBuergerID().equals(p.getBuergerID())){
                return true;
            } else {
                return false;
            }

        } return false;
    }

    // Klassenmethodhilfer Funktionen
    public static boolean isLatinLetter(char c) {
        if ((c >= 65 && c <= 90) || (c >= 97 && c <= 122)) {
            return true;
        }
        return false;
    }
    //

    // Regex Funktionen
    public static boolean NameValid(String in) {
        return Pattern.matches("[a-zA-Z. ]{2,20}", in);
    }

    //
    public static boolean BuergerIDValid(String bg) {
        return Pattern.matches("[1-9]{1}[0-9]{6}", bg);
    }
}