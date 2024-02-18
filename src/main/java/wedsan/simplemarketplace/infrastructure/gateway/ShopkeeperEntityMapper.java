package wedsan.simplemarketplace.infrastructure.gateway;

import org.springframework.stereotype.Component;
import wedsan.simplemarketplace.core.domain.Address;
import wedsan.simplemarketplace.core.domain.Shopkeeper;
import wedsan.simplemarketplace.core.domain.ShopkeeperDocument;
import wedsan.simplemarketplace.infrastructure.entity.Address.AddressEntity;
import wedsan.simplemarketplace.infrastructure.entity.Address.CityEntity;
import wedsan.simplemarketplace.infrastructure.entity.Address.ProvinceEntity;
import wedsan.simplemarketplace.infrastructure.entity.ShopkeeperEntity;

@Component
public class ShopkeeperEntityMapper {

    public ShopkeeperEntity toEntity(Shopkeeper shopkeeper){
        return new ShopkeeperEntity(shopkeeper.getId(),
                shopkeeper.getName(),
                shopkeeper.getDocument().getDocumentNumber(),
                shopkeeper.getEmail(),
                toAddressEntity(shopkeeper.getAddress()));
    }

    public Shopkeeper toDomainObj(ShopkeeperEntity shopkeeperEntity){
        return new Shopkeeper(shopkeeperEntity.getId(),
                shopkeeperEntity.getName(),
                new ShopkeeperDocument(shopkeeperEntity.getDocument()),
                shopkeeperEntity.getEmail(),
                toAddress(shopkeeperEntity.getAddress()));
    }

    private AddressEntity toAddressEntity(Address address){
        return new AddressEntity(
                address.getId(),
                address.getZipCode(),
                address.getStreetAddress(),
                new CityEntity(address.getCity()),
                new ProvinceEntity(address.getProvince()),
                address.getAddressNumber());
    }

    private Address toAddress(AddressEntity address){
        return new Address(
                address.getId(),
                address.getZipCode(),
                address.getStreetAddress(),
                address.getCity().getCityName(),
                address.getProvince().getProvinceName(),
                address.getAddressNumber());
    }
}
