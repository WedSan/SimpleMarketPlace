package wedsan.simplemarketplace.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import wedsan.simplemarketplace.application.usecase.CreateCustomerUseCase;
import wedsan.simplemarketplace.application.usecase.gateway.CustomerGateway;
import wedsan.simplemarketplace.application.usecase.impl.CreateCustomerUseCaseImpl;
import wedsan.simplemarketplace.infrastructure.gateway.CustomerRepositoryGateway;
import wedsan.simplemarketplace.infrastructure.persistence.CustomerRepository;

@Configuration
public class UserConfig {
    @Bean
    CustomerGateway customerGateway(CustomerRepository customerRepository){
        return new CustomerRepositoryGateway(customerRepository);
    }

    @Bean
    CreateCustomerUseCase createCustomerUseCase(CustomerGateway customerGateway){
        return new CreateCustomerUseCaseImpl(customerGateway);
    }

}
