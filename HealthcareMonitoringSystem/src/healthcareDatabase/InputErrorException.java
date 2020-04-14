package healthcareDatabase;

public class InputErrorException extends Exception {
    private static final long serialVersionUID = 1L;

    public InputErrorException(String msg) {
        super(msg);
    }
}