package wedsan.simplemarketplace.infrastructure.gateway;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import wedsan.simplemarketplace.application.usecase.gateway.PasswordEncoderGateway;

@Component
public class PasswordEncodeGatewayImpl implements PasswordEncoderGateway {

    private final PasswordEncoder passwordEncoder;

    public PasswordEncodeGatewayImpl(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public String encode(String password) {
        return this.passwordEncoder.encode(password);
    }
}
