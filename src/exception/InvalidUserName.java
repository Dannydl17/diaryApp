package exception;

public class InvalidUserName extends RuntimeException {
    public InvalidUserName(String message) {
        super(message);
    }
}
