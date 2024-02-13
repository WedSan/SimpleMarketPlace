package wedsan.simplemarketplace.infrastructure.dto.request;

import jakarta.validation.constraints.NotBlank;
import wedsan.simplemarketplace.core.domain.Address;

public record AddressDto(
        @NotBlank String zipCode,
        @NotBlank String streetAddress,
        @NotBlank String city,
        @NotBlank String province,
        @NotBlank String addressNumber
) {
    public AddressDto(Address address) {
        this(address.getZipCode(), address.getAddressNumber(), address.getCity(), address.getProvince(), address.getAddressNumber());
    }

}