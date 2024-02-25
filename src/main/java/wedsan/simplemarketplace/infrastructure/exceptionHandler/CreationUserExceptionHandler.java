package wedsan.simplemarketplace.infrastructure.exceptionHandler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import wedsan.simplemarketplace.core.DuplicateDocumentException;
import wedsan.simplemarketplace.core.exception.UserDocumentInvalidException;

@ControllerAdvice
public class CreationUserExceptionHandler {

    @ExceptionHandler({UserDocumentInvalidException.class, DuplicateDocumentException.class})
    public ResponseEntity<Object> handleUserCreationException(Exception ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

}
