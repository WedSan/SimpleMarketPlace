package wedsan.simplemarketplace.infrastructure.dto.response;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import wedsan.simplemarketplace.core.domain.Address;
import wedsan.simplemarketplace.core.domain.Customer;
import wedsan.simplemarketplace.infrastructure.dto.request.AddressDto;

public record CustomerCreationResponse(
        @NotBlank
        String name,
        @NotBlank
        String document,
        @Email
        String email,
        @NotBlank
        AddressDto address
) {
        public CustomerCreationResponse(Customer customer) {
                this(
                        customer.getName(),
                        customer.getDocument(),
                        customer.getEmail(),
                        new AddressDto(customer.getAddress())
                );
        }
}













