package wedsan.simplemarketplace.infrastructure.gateway;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import wedsan.simplemarketplace.application.usecase.gateway.UserAuthenticatorGateway;
import wedsan.simplemarketplace.core.domain.AuthLogin;
import wedsan.simplemarketplace.core.domain.User;
@Component
public class UserAuthenticatorGatewayImpl implements UserAuthenticatorGateway {

    private AuthenticationManager authenticationManager;

    public UserAuthenticatorGatewayImpl(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public boolean verifyCredentials(AuthLogin user) {
        try{
            Authentication auth = new UsernamePasswordAuthenticationToken(user.email(), user.password());
            authenticationManager.authenticate(auth);
            return true;
        }
        catch(AuthenticationException ex){
            return false;
        }

    }
}
