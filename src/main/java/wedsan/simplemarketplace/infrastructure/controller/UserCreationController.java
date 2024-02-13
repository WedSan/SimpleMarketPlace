package wedsan.simplemarketplace.infrastructure.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wedsan.simplemarketplace.application.usecase.CreateCustomerUseCase;
import wedsan.simplemarketplace.core.domain.Customer;
import wedsan.simplemarketplace.infrastructure.dto.request.CustomerCreationRequest;
import wedsan.simplemarketplace.infrastructure.dto.response.CustomerCreationResponse;
import wedsan.simplemarketplace.infrastructure.mapper.UserMapper;

@RestController
@RequestMapping("api/user/create")
public class UserCreationController {

    private final CreateCustomerUseCase createCustomerUseCase;
    private final UserMapper userMapper;

    public UserCreationController(CreateCustomerUseCase createCustomerUseCase, UserMapper userMapper) {
        this.createCustomerUseCase = createCustomerUseCase;
        this.userMapper = userMapper;
    }

    @PostMapping
    public ResponseEntity<CustomerCreationResponse> createCustomer(@RequestBody CustomerCreationRequest customerCreationRequest){
        Customer customerToBeSaved = this.userMapper.toCustomer(customerCreationRequest);
        Customer customerSaved = this.createCustomerUseCase.create(customerToBeSaved);
        CustomerCreationResponse response =  this.userMapper.toCustomerCreationResponse(customerSaved);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
