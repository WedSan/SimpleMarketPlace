package wedsan.simplemarketplace.application.usecase.impl;

import wedsan.simplemarketplace.application.usecase.CreateCustomerUseCase;
import wedsan.simplemarketplace.application.usecase.gateway.CustomerGateway;
import wedsan.simplemarketplace.core.domain.Customer;

public class CreateCustomerUseCaseImpl implements CreateCustomerUseCase {

    private final CustomerGateway customerGateway;

    @Override
    public Customer create(Customer customerToBeSaved) {
        return customerGateway.save(customerToBeSaved);
    }
}
