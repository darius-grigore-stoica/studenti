package exceptions;

public class GrupaException extends Throwable{
    private String message;

    public GrupaException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
