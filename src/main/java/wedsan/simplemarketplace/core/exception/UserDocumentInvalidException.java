package wedsan.simplemarketplace.core.exception;

public class UserDocumentInvalidException extends IllegalArgumentException{

    public UserDocumentInvalidException() {
    }

    public UserDocumentInvalidException(String s) {
        super(s);
    }

    public UserDocumentInvalidException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserDocumentInvalidException(Throwable cause) {
        super(cause);
    }
}
