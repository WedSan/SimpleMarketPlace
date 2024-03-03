package wedsan.simplemarketplace.infrastructure.dto.response;

import java.util.Map;

public record ValidationErrorResponse(
        String message,
        Map<String, String> fieldErrors
) {
}
