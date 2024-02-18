package wedsan.simplemarketplace.application.usecase.gateway;

import wedsan.simplemarketplace.core.domain.Customer;

public interface CustomerGateway {

    Customer save(Customer customerToBeSaved);

    boolean existsByDocument(String document);
}
