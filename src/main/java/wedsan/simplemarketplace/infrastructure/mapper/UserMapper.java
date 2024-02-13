package wedsan.simplemarketplace.infrastructure.mapper;

import wedsan.simplemarketplace.core.domain.Address;
import wedsan.simplemarketplace.core.domain.Customer;
import wedsan.simplemarketplace.core.domain.Product;
import wedsan.simplemarketplace.infrastructure.dto.request.CustomerCreationRequest;
import wedsan.simplemarketplace.infrastructure.dto.response.CustomerCreationResponse;

import java.util.ArrayList;

public class UserMapper {

    public Customer toCustomer(CustomerCreationRequest customerCreationRequest){
        Address address = new Address(customerCreationRequest.address().zipCode(),
                customerCreationRequest.address().streetAddress(),
                customerCreationRequest.address().city(),
                customerCreationRequest.address().province(),
                customerCreationRequest.address().addressNumber());
        return new Customer(customerCreationRequest.name(), customerCreationRequest.document(), customerCreationRequest.email(), address);
    }

    public CustomerCreationResponse toCustomerCreationResponse(Customer customer){
        return new CustomerCreationResponse(customer);
    }
}
