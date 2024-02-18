package wedsan.simplemarketplace.core;

import wedsan.simplemarketplace.application.usecase.gateway.CustomerGateway;
import wedsan.simplemarketplace.application.usecase.gateway.ShopkeeperGateway;
import wedsan.simplemarketplace.application.usecase.gateway.UserGateway;
import wedsan.simplemarketplace.core.domain.Customer;
import wedsan.simplemarketplace.core.domain.User;
import wedsan.simplemarketplace.core.domain.UserValidator;
import wedsan.simplemarketplace.infrastructure.persistence.CustomerRepository;

public class DuplicateDocumentValidator extends UserValidator {

    private final CustomerGateway customerGateway;

    private final ShopkeeperGateway shopkeeperGateway;


    public DuplicateDocumentValidator(UserGateway userGateway, CustomerGateway customerGateway, ShopkeeperGateway shopkeeperGateway) {
        super(userGateway);
        this.customerGateway = customerGateway;
        this.shopkeeperGateway = shopkeeperGateway;
    }

    @Override
    public void validate(User user) {
        if(user instanceof Customer){
            if(this.customerGateway.existsByDocument(user.getDocument().getDocumentNumber())){
                throw new DuplicateDocumentException("The document"+user.getDocument() +"is already registered");
            }
        }
        else{
            if(this.shopkeeperGateway.existsByDocument(user.getDocument().getDocumentNumber())){
                throw new DuplicateDocumentException("The document"+user.getDocument() +"is already registered");
            }
        }
    }

}
