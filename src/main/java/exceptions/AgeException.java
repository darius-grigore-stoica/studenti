package exceptions;

public class AgeException extends Throwable {
    private String message;

    public AgeException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
