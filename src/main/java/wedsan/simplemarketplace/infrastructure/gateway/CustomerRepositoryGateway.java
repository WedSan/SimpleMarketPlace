package wedsan.simplemarketplace.infrastructure.gateway;

import wedsan.simplemarketplace.application.usecase.gateway.CustomerGateway;
import wedsan.simplemarketplace.core.domain.Customer;
import wedsan.simplemarketplace.infrastructure.entity.CustomerEntity;
import wedsan.simplemarketplace.infrastructure.persistence.CustomerRepository;

public class CustomerRepositoryGateway implements CustomerGateway {

    private final CustomerRepository customerRepository;

    private final CustomerEntityMapper customerEntityMapper;

    public CustomerRepositoryGateway(CustomerRepository customerRepository, CustomerEntityMapper customerEntityMapper) {
        this.customerRepository = customerRepository;
        this.customerEntityMapper = customerEntityMapper;
    }

    @Override
    public Customer save(Customer customerToBeSaved) {
        CustomerEntity customerEntityToBeSaved = this.customerEntityMapper.toEntity(customerToBeSaved);
        CustomerEntity customerEntitySaved =  this.customerRepository.save(customerEntityToBeSaved);
        return this.customerEntityMapper.toDomainObj(customerEntitySaved);
    }
}
