package wedsan.simplemarketplace.core.domain;

import wedsan.simplemarketplace.application.usecase.gateway.UserGateway;

public abstract class UserValidator {

    protected final UserGateway userGateway;

    public UserValidator(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    public abstract void validate(User user);
}
