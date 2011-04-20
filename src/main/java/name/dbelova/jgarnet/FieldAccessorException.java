package name.dbelova.jgarnet;

/**
 * @author dbelova
 */
public class FieldAccessorException extends Exception {
    public FieldAccessorException() {
        super();
    }

    public FieldAccessorException(String message) {
        super(message);
    }

    public FieldAccessorException(String message, Throwable cause) {
        super(message, cause);
    }

    public FieldAccessorException(Throwable cause) {
        super(cause);
    }
}
