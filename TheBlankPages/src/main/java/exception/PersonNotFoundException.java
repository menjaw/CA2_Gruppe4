package exception;

public class PersonNotFoundException extends Exception {
    
    public PersonNotFoundException() {
    }

    public PersonNotFoundException(String msg) {
        super(msg);
    }
}