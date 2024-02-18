package wedsan.simplemarketplace.infrastructure.gateway;

import org.springframework.stereotype.Component;
import wedsan.simplemarketplace.core.domain.Address;
import wedsan.simplemarketplace.infrastructure.entity.Address.AddressEntity;
import wedsan.simplemarketplace.infrastructure.entity.Address.CityEntity;
import wedsan.simplemarketplace.infrastructure.entity.Address.ProvinceEntity;

@Component
public class AddressEntityMapper {

    public AddressEntityMapper() {
    }

    public Address toDomain(AddressEntity address){
        return new Address(
                address.getId(),
                address.getZipCode(),
                address.getStreetAddress(),
                address.getCity().getCityName(),
                address.getProvince().getProvinceName(),
                address.getAddressNumber());
    }

    public AddressEntity toEntity(Address address){
        return new AddressEntity(
                address.getId(),
                address.getZipCode(),
                address.getStreetAddress(),
                new CityEntity(address.getCity()),
                new ProvinceEntity(address.getProvince()) ,
                address.getAddressNumber());
    }
}
