package wedsan.simplemarketplace.infrastructure.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CustomerCreationRequest(
        @NotBlank
        String name,
        @NotBlank
        String document,
        @Email
        String email,
        @NotBlank
        @Size(min = 8, message = "The password must be at least 8 characters long")
        String password,
        @Valid
        AddressDto address
) {
}
