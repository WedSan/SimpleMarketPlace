package wedsan.simplemarketplace.application.usecase.gateway;

public interface RefreshTokenGateway {

    boolean validateRefreshToken(String token);

    String generateRefreshToken(String subject);
}
