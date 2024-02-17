package wedsan.simplemarketplace.infrastructure.gateway;

import wedsan.simplemarketplace.core.domain.Address;
import wedsan.simplemarketplace.core.domain.Customer;
import wedsan.simplemarketplace.core.domain.CustomerDocument;
import wedsan.simplemarketplace.infrastructure.entity.AddressEntity;
import wedsan.simplemarketplace.infrastructure.entity.CustomerEntity;

public class CustomerEntityMapper {
    public CustomerEntity toEntity(Customer customer){
        return new CustomerEntity(customer.getId(),
                customer.getName(),
                customer.getDocument().getDocumentNumber(),
                customer.getEmail(),
                new AddressEntity(customer.getAddress()));
    }

    public Customer toDomainObj(CustomerEntity customerEntity){
        return new Customer(customerEntity.getId(),
                customerEntity.getName(),
                new CustomerDocument(customerEntity.getDocument()),
                customerEntity.getEmail(),
                toAddressDomain(customerEntity.getAddress()));
    }

    private Address toAddressDomain(AddressEntity address){
        return new Address(address.getZipCode(),
                address.getStreetAddress(),
                address.getCity().getCityName(),
                address.getProvince().getProvinceName(),
                address.getAddressNumber());
    }
}
