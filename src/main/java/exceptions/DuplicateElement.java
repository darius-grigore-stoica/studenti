package exceptions;

public class DuplicateElement extends Throwable {
    private String message;

    public DuplicateElement(String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
