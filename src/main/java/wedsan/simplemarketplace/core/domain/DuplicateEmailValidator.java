package wedsan.simplemarketplace.core.domain;

import wedsan.simplemarketplace.application.usecase.gateway.UserGateway;

public class DuplicateEmailValidator extends UserValidator {

    public DuplicateEmailValidator(UserGateway userGateway) {
        super(userGateway);
    }

    @Override
    public void validate(User user) {
        if(super.userGateway.existsByEmail(user.getEmail())){
            throw new DuplicateEmailException("Email is already registered");
        }
        else{
            return;
        }
    }
}
