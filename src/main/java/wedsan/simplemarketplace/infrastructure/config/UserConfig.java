package wedsan.simplemarketplace.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import wedsan.simplemarketplace.application.usecase.CreateCustomerUseCase;
import wedsan.simplemarketplace.application.usecase.CreateShopkeeperUseCase;
import wedsan.simplemarketplace.application.usecase.gateway.CustomerGateway;
import wedsan.simplemarketplace.application.usecase.gateway.PasswordEncoderGateway;
import wedsan.simplemarketplace.application.usecase.gateway.ShopkeeperGateway;
import wedsan.simplemarketplace.application.usecase.gateway.UserGateway;
import wedsan.simplemarketplace.application.usecase.impl.CreateCustomerUseCaseImpl;
import wedsan.simplemarketplace.application.usecase.impl.CreateShopkeeperUseCaseImpl;
import wedsan.simplemarketplace.core.DuplicateDocumentValidator;
import wedsan.simplemarketplace.core.domain.DuplicateEmailValidator;
import wedsan.simplemarketplace.core.domain.UserValidator;
import wedsan.simplemarketplace.infrastructure.gateway.ShopkeeperRepositoryGateway;

import java.util.List;

@Configuration
public class UserConfig {

    @Bean
    CreateShopkeeperUseCase createShopkeeperUseCase(ShopkeeperGateway shopkeeperGateway,
                                                    List<UserValidator> listUserValidator,
                                                    PasswordEncoderGateway passwordEncoderGateway){
        return new CreateShopkeeperUseCaseImpl(shopkeeperGateway,listUserValidator, passwordEncoderGateway);
    }

    @Bean
    List<UserValidator> userValidator(UserGateway userGateway, CustomerGateway customerGateway, ShopkeeperGateway shopkeeperGateway){
       return List.of(new DuplicateEmailValidator(userGateway), new DuplicateDocumentValidator(userGateway,customerGateway, shopkeeperGateway));
    }

    @Bean
    CreateCustomerUseCase createCustomerUseCase(CustomerGateway customerGateway, List<UserValidator> userValidatorList, PasswordEncoderGateway passwordEncoder){
        return new CreateCustomerUseCaseImpl(customerGateway, userValidatorList, passwordEncoder);
    }

}
