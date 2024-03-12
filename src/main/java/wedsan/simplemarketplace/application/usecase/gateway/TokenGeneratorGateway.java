package wedsan.simplemarketplace.application.usecase.gateway;

import wedsan.simplemarketplace.core.domain.TokenType;

public interface TokenGeneratorGateway {

    String generateToken(String subject);
    String generateToken(String subject, TokenType tokenType);
}
