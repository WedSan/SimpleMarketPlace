package wedsan.simplemarketplace.infrastructure.gateway;

import wedsan.simplemarketplace.application.usecase.gateway.CustomerGateway;
import wedsan.simplemarketplace.core.domain.Customer;
import wedsan.simplemarketplace.infrastructure.persistence.CustomerRepository;

public class CustomerRepositoryGateway implements CustomerGateway {

    private CustomerRepository customerRepository;

    @Override
    public Customer save(Customer customerToBeSaved) {
        return this.customerRepository.save(customerToBeSaved);
    }
}
