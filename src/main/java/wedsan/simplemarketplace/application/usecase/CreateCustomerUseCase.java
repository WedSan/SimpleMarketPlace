package wedsan.simplemarketplace.application.usecase;

import wedsan.simplemarketplace.core.domain.Customer;

public interface CreateCustomerUseCase {

    public Customer create(Customer customerToBeSaved);
}
