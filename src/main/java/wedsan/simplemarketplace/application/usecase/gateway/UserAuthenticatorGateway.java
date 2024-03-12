package wedsan.simplemarketplace.application.usecase.gateway;

import wedsan.simplemarketplace.core.domain.AuthLogin;
import wedsan.simplemarketplace.core.domain.User;

public interface UserAuthenticatorGateway {

    boolean verifyCredentials(AuthLogin user);
}
