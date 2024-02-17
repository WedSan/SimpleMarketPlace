package wedsan.simplemarketplace.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import wedsan.simplemarketplace.application.usecase.CreateCustomerUseCase;
import wedsan.simplemarketplace.application.usecase.gateway.CustomerGateway;
import wedsan.simplemarketplace.application.usecase.impl.CreateCustomerUseCaseImpl;
import wedsan.simplemarketplace.infrastructure.entity.CustomerEntity;
import wedsan.simplemarketplace.infrastructure.gateway.CustomerEntityMapper;
import wedsan.simplemarketplace.infrastructure.gateway.CustomerRepositoryGateway;
import wedsan.simplemarketplace.infrastructure.mapper.UserMapper;
import wedsan.simplemarketplace.infrastructure.persistence.CustomerRepository;

@Configuration
public class UserConfig {

    @Bean
    CustomerEntityMapper customerEntityMapper(){
        return new CustomerEntityMapper();
    }

    @Bean
    UserMapper userMapper(){
        return new UserMapper();
    }

    @Bean
    CustomerGateway customerGateway(CustomerRepository customerRepository, CustomerEntityMapper customerEntityMapper){
        return new CustomerRepositoryGateway(customerRepository, customerEntityMapper);
    }

    @Bean
    CreateCustomerUseCase createCustomerUseCase(CustomerGateway customerGateway){
        return new CreateCustomerUseCaseImpl(customerGateway);
    }

}
