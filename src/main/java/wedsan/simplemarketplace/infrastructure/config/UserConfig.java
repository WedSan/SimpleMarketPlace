package wedsan.simplemarketplace.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import wedsan.simplemarketplace.application.usecase.CreateCustomerUseCase;
import wedsan.simplemarketplace.application.usecase.gateway.CustomerGateway;
import wedsan.simplemarketplace.application.usecase.gateway.ShopkeeperGateway;
import wedsan.simplemarketplace.application.usecase.gateway.UserGateway;
import wedsan.simplemarketplace.application.usecase.impl.CreateCustomerUseCaseImpl;
import wedsan.simplemarketplace.core.domain.DuplicateEmailValidator;
import wedsan.simplemarketplace.core.domain.UserValidator;
import wedsan.simplemarketplace.infrastructure.gateway.CustomerEntityMapper;
import wedsan.simplemarketplace.infrastructure.gateway.CustomerRepositoryGateway;
import wedsan.simplemarketplace.infrastructure.gateway.ShopkeeperRepositoryGateway;
import wedsan.simplemarketplace.infrastructure.mapper.UserMapper;
import wedsan.simplemarketplace.infrastructure.persistence.CustomerRepository;

import java.util.List;

@Configuration
public class UserConfig {

    @Bean
    CustomerEntityMapper customerEntityMapper() {
        return new CustomerEntityMapper();
    }

    @Bean
    List<UserValidator> userValidator(UserGateway userGateway){
       return List.of(new DuplicateEmailValidator(userGateway));
    }

    @Bean
    CreateCustomerUseCase createCustomerUseCase(CustomerGateway customerGateway, List<UserValidator> userValidatorList){
        return new CreateCustomerUseCaseImpl(customerGateway, userValidatorList);
    }

}
