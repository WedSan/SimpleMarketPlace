package wedsan.simplemarketplace.application.usecase.impl;

import wedsan.simplemarketplace.application.usecase.CreateCustomerUseCase;
import wedsan.simplemarketplace.application.usecase.gateway.CustomerGateway;
import wedsan.simplemarketplace.core.domain.Customer;
import wedsan.simplemarketplace.core.domain.UserValidator;

import java.util.List;

public class CreateCustomerUseCaseImpl implements CreateCustomerUseCase {

    private final CustomerGateway customerGateway;
    private final List<UserValidator> userValidatorList;

    public CreateCustomerUseCaseImpl(CustomerGateway customerGateway, List<UserValidator> userValidatorList) {
        this.customerGateway = customerGateway;
        this.userValidatorList = userValidatorList;
    }

    @Override
    public Customer create(Customer customerToBeSaved) {
        userValidatorList.forEach(validator-> validator.validate(customerToBeSaved));
        return customerGateway.save(customerToBeSaved);
    }
}
