package wedsan.simplemarketplace.infrastructure.dto.response;
import wedsan.simplemarketplace.core.domain.Shopkeeper;
import wedsan.simplemarketplace.infrastructure.dto.request.AddressDto;

public record ShopkeeperCreationResponse(
        String name,
        String document,
        String email,
        AddressDto address
) {
    public ShopkeeperCreationResponse(Shopkeeper shopkeeper) {
        this(
                shopkeeper.getName(),
                shopkeeper.getDocument().getDocumentNumber(),
                shopkeeper.getEmail(),
                new AddressDto(shopkeeper.getAddress())
        );
    }
}
