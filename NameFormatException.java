public class NameFormatException extends RuntimeException{
    private String message;

    // Wir erben Konstruktor mit String von Exception Klasse
    public NameFormatException(String msg){
        super(msg);
    }

    public void setMessage(String msg){
        this.message = msg;
    }
    public String getMessage(){
        return message;
    }

}
