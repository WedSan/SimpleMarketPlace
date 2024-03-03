package wedsan.simplemarketplace.infrastructure.exceptionHandler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import wedsan.simplemarketplace.infrastructure.dto.response.ValidationErrorResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class ValidationErrorHandler {

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<Object> handleException(MethodArgumentNotValidException ex){
        Map<String, String> fieldErros = new HashMap<>();

        ex.getBindingResult().getFieldErrors()  .forEach(error->
                fieldErros.put(error.getField(), error.getDefaultMessage()));

        ValidationErrorResponse validationErrorResponse = new ValidationErrorResponse("Validation error", fieldErros);

        return ResponseEntity.badRequest().body(validationErrorResponse);
    }
}
