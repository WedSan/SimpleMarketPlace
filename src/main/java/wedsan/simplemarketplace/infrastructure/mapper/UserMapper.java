package wedsan.simplemarketplace.infrastructure.mapper;

import org.springframework.stereotype.Component;
import wedsan.simplemarketplace.core.domain.Address;
import wedsan.simplemarketplace.core.domain.Customer;
import wedsan.simplemarketplace.core.domain.CustomerDocument;
import wedsan.simplemarketplace.infrastructure.dto.request.CustomerCreationRequest;
import wedsan.simplemarketplace.infrastructure.dto.response.CustomerCreationResponse;

@Component
public class UserMapper {

    public Customer toCustomer(CustomerCreationRequest customerCreationRequest){
        Address address = new Address(customerCreationRequest.address().zipCode(),
                customerCreationRequest.address().streetAddress(),
                customerCreationRequest.address().city(),
                customerCreationRequest.address().province(),
                customerCreationRequest.address().addressNumber());
        return new Customer(customerCreationRequest.name(),
                new CustomerDocument(customerCreationRequest.document()),
                customerCreationRequest.email(),
                address);
    }

    public CustomerCreationResponse toCustomerCreationResponse(Customer customer){
        return new CustomerCreationResponse(customer);
    }
}
