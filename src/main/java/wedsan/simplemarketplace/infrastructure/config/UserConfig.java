package wedsan.simplemarketplace.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import wedsan.simplemarketplace.application.usecase.CreateCustomerUseCase;
import wedsan.simplemarketplace.application.usecase.gateway.CustomerGateway;
import wedsan.simplemarketplace.application.usecase.gateway.ShopkeeperGateway;
import wedsan.simplemarketplace.application.usecase.gateway.UserGateway;
import wedsan.simplemarketplace.application.usecase.impl.CreateCustomerUseCaseImpl;
import wedsan.simplemarketplace.core.DuplicateDocumentValidator;
import wedsan.simplemarketplace.core.domain.DuplicateEmailValidator;
import wedsan.simplemarketplace.core.domain.UserValidator;

import java.util.List;

@Configuration
public class UserConfig {

    @Bean
    List<UserValidator> userValidator(UserGateway userGateway, CustomerGateway customerGateway, ShopkeeperGateway shopkeeperGateway){
       return List.of(new DuplicateEmailValidator(userGateway), new DuplicateDocumentValidator(userGateway,customerGateway, shopkeeperGateway));
    }

    @Bean
    CreateCustomerUseCase createCustomerUseCase(CustomerGateway customerGateway, List<UserValidator> userValidatorList){
        return new CreateCustomerUseCaseImpl(customerGateway, userValidatorList);
    }

}
