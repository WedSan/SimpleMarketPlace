package wedsan.simplemarketplace.infrastructure.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record ShopkeeperCreationRequest (
        @NotBlank
        String name,
        @NotBlank
        String document,
        @Email
        String email,
        @NotBlank
        AddressDto address
){}
