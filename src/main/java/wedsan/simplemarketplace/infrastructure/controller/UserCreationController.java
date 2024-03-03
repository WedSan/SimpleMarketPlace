package wedsan.simplemarketplace.infrastructure.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wedsan.simplemarketplace.application.usecase.CreateCustomerUseCase;
import wedsan.simplemarketplace.application.usecase.CreateShopkeeperUseCase;
import wedsan.simplemarketplace.core.domain.Customer;
import wedsan.simplemarketplace.core.domain.Shopkeeper;
import wedsan.simplemarketplace.infrastructure.dto.request.CustomerCreationRequest;
import wedsan.simplemarketplace.infrastructure.dto.request.ShopkeeperCreationRequest;
import wedsan.simplemarketplace.infrastructure.dto.response.ShopkeeperCreationResponse;
import wedsan.simplemarketplace.infrastructure.dto.response.CustomerCreationResponse;
import wedsan.simplemarketplace.infrastructure.mapper.UserDtoMapper;

@RestController
@RequestMapping("api/user/")
public class UserCreationController {

    private final CreateCustomerUseCase createCustomerUseCase;

    private final CreateShopkeeperUseCase shopkeeperUseCase;

    private final UserDtoMapper userDtoMapper;

    public UserCreationController(CreateCustomerUseCase createCustomerUseCase, CreateShopkeeperUseCase shopkeeperUseCase, UserDtoMapper userDtoMapper) {
        this.createCustomerUseCase = createCustomerUseCase;
        this.shopkeeperUseCase = shopkeeperUseCase;
        this.userDtoMapper = userDtoMapper;
    }

    @PostMapping("customer")
    public ResponseEntity<CustomerCreationResponse> createCustomer(@RequestBody @Validated CustomerCreationRequest customerCreationRequest){
        Customer customerToBeSaved = this.userDtoMapper.toCustomer(customerCreationRequest);
        Customer customerSaved = this.createCustomerUseCase.create(customerToBeSaved);
        CustomerCreationResponse response =  this.userDtoMapper.toCustomerCreationResponse(customerSaved);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("shopkeeper")
    public ResponseEntity<ShopkeeperCreationResponse> createShopkeeper(@RequestBody @Validated ShopkeeperCreationRequest shopkeeperCreationResponse){
        Shopkeeper shopkeeperToBeSaved = this.userDtoMapper.toShopkeeper(shopkeeperCreationResponse);
        Shopkeeper shopkeeperSaved = this.shopkeeperUseCase.create(shopkeeperToBeSaved);
        ShopkeeperCreationResponse response = this.userDtoMapper.toShopkeeperCreationResponse(shopkeeperSaved);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
