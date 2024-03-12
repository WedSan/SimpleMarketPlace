package wedsan.simplemarketplace.application.usecase;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import wedsan.simplemarketplace.core.domain.AuthLogin;
import wedsan.simplemarketplace.core.domain.AuthenticationToken;
import wedsan.simplemarketplace.core.domain.User;

public interface LogInUseCase {
    boolean verifyUserCredentials(AuthLogin user);

    AuthenticationToken generateTokens(AuthLogin user);
}
