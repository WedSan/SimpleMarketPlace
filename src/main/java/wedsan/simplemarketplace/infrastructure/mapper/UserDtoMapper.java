package wedsan.simplemarketplace.infrastructure.mapper;

import org.springframework.stereotype.Component;
import wedsan.simplemarketplace.core.domain.*;
import wedsan.simplemarketplace.infrastructure.dto.request.CustomerCreationRequest;
import wedsan.simplemarketplace.infrastructure.dto.request.ShopkeeperCreationRequest;
import wedsan.simplemarketplace.infrastructure.dto.response.CustomerCreationResponse;
import wedsan.simplemarketplace.infrastructure.dto.response.ShopkeeperCreationResponse;

import java.util.Set;

@Component
public class UserDtoMapper {

    public Customer toCustomer(CustomerCreationRequest customerCreationRequest){
        Address address = new Address(
                null,
                customerCreationRequest.address().zipCode(),
                customerCreationRequest.address().streetAddress(),
                customerCreationRequest.address().city(),
                customerCreationRequest.address().province(),
                customerCreationRequest.address().addressNumber());
        return new Customer(customerCreationRequest.name(),
                new CustomerDocument(customerCreationRequest.document()),
                customerCreationRequest.email(),
                customerCreationRequest.password(),
                Set.of(UserRole.USER),
                address);
    }


    public CustomerCreationResponse toCustomerCreationResponse(Customer customer){
        return new CustomerCreationResponse(customer);
    }

    public Shopkeeper toShopkeeper(ShopkeeperCreationRequest shopkeeperCreationRequest){
        Address address = new Address(
                null,
                shopkeeperCreationRequest.address().zipCode(),
                shopkeeperCreationRequest.address().streetAddress(),
                shopkeeperCreationRequest.address().city(),
                shopkeeperCreationRequest.address().province(),
                shopkeeperCreationRequest.address().addressNumber());
        return new Shopkeeper(null,
                shopkeeperCreationRequest.name(),
                new ShopkeeperDocument(shopkeeperCreationRequest.document()),
                shopkeeperCreationRequest.email(),
                shopkeeperCreationRequest.password(),
                Set.of(UserRole.USER),
                address
                );
    }

    public ShopkeeperCreationResponse toShopkeeperCreationResponse(Shopkeeper shopkeeper){
        return new ShopkeeperCreationResponse(shopkeeper);
    }
}
