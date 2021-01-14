package ramin.seyghaly.banner_view.exceptions;

public class AdsException extends RuntimeException {

    public static final String INITIALIZE_EXCEPTION = "You must first initialize using the Init method";

    public AdsException() {
        super();
    }

    public AdsException(String message) {
        super(message);
    }

    public AdsException(String message, Throwable cause) {
        super(message, cause);
    }

    public AdsException(Throwable cause) {
        super(cause);
    }

}
