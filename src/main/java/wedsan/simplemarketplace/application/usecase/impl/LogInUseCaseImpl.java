package wedsan.simplemarketplace.application.usecase.impl;

import wedsan.simplemarketplace.application.usecase.LogInUseCase;
import wedsan.simplemarketplace.application.usecase.gateway.RefreshTokenGateway;
import wedsan.simplemarketplace.application.usecase.gateway.TokenGeneratorGateway;
import wedsan.simplemarketplace.application.usecase.gateway.UserAuthenticatorGateway;
import wedsan.simplemarketplace.core.domain.AuthLogin;
import wedsan.simplemarketplace.core.domain.AuthenticationToken;
import wedsan.simplemarketplace.core.domain.User;

public class LogInUseCaseImpl implements LogInUseCase {

    private TokenGeneratorGateway tokenGenerator;

    private UserAuthenticatorGateway userAuthenticator;

    private RefreshTokenGateway refreshTokenGenerator;

    public LogInUseCaseImpl(TokenGeneratorGateway tokenGenerator, UserAuthenticatorGateway userAuthenticator, RefreshTokenGateway refreshTokenGateway) {
        this.tokenGenerator = tokenGenerator;
        this.userAuthenticator = userAuthenticator;
        this.refreshTokenGenerator = refreshTokenGateway;
    }

    @Override
    public boolean verifyUserCredentials(AuthLogin user) {
        return userAuthenticator.verifyCredentials(user);
    }

    @Override
    public AuthenticationToken generateTokens(AuthLogin user) {
        String token = tokenGenerator.generateToken(user.email());
        String refreshToken = refreshTokenGenerator.generateRefreshToken(user.password());
        return new AuthenticationToken(token, refreshToken);
    }
}
