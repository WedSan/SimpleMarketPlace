package wedsan.simplemarketplace.infrastructure.gateway;

import org.springframework.stereotype.Component;
import wedsan.simplemarketplace.core.domain.Address;
import wedsan.simplemarketplace.core.domain.Customer;
import wedsan.simplemarketplace.core.domain.CustomerDocument;
import wedsan.simplemarketplace.infrastructure.entity.Address.AddressEntity;
import wedsan.simplemarketplace.infrastructure.entity.CustomerEntity;

@Component
public class CustomerEntityMapper {

    private final AddressEntityMapper addressEntityMapper;

    public CustomerEntityMapper(AddressEntityMapper addressEntityMapper) {
        this.addressEntityMapper = addressEntityMapper;
    }

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
                addressEntityMapper.toDomain(customerEntity.getAddress()));
    }


}
