package wedsan.simplemarketplace.core;

public class DuplicateDocumentException extends RuntimeException{

    public DuplicateDocumentException() {
    }

    public DuplicateDocumentException(String message) {
        super(message);
    }

    public DuplicateDocumentException(String message, Throwable cause) {
        super(message, cause);
    }

    public DuplicateDocumentException(Throwable cause) {
        super(cause);
    }

    public DuplicateDocumentException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
