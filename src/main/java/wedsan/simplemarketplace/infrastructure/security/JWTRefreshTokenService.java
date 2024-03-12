package wedsan.simplemarketplace.infrastructure.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.stereotype.Component;
import wedsan.simplemarketplace.application.usecase.gateway.RefreshTokenGateway;
import wedsan.simplemarketplace.infrastructure.entity.security.RefreshTokenEntity;
import wedsan.simplemarketplace.infrastructure.persistence.RefreshTokenRepository;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;
@Component
public class JWTRefreshTokenService implements RefreshTokenGateway {

    private RefreshTokenRepository refreshTokenRepository;

    private JWTService jwtService;

    private JWTKey jwtKey;

    public JWTRefreshTokenService(RefreshTokenRepository refreshTokenRepository) {
        this.refreshTokenRepository = refreshTokenRepository;
    }

    @Override
    public boolean validateRefreshToken(String refreshToken) {
        String password = jwtKey.getKEY();

        try{
            JWT.require(Algorithm.HMAC256(password))
                    .withClaim("TypeToken", "RefreshToken")
                    .build()
                    .verify(refreshToken);
        }catch (JWTVerificationException ex){
            return false;
        }

        Optional<RefreshTokenEntity> optionalRefreshToken = refreshTokenRepository.findByRefreshToken(refreshToken);

        return optionalRefreshToken.isPresent();
    }

    @Override
    public String generateRefreshToken(String subject) {
        LocalDateTime issuedDateLocalDate =  LocalDateTime.now().plusHours(1);
        LocalDateTime expiredDateLocalDate = LocalDateTime.now().plusDays(7);

        Date issuedDate = Date.from(issuedDateLocalDate.atZone(ZoneId.systemDefault()).toInstant());
        Date expiredDate = Date.from(expiredDateLocalDate.atZone(ZoneId.systemDefault()).toInstant());

        return this.jwtService.generateToken(subject, TokenTypeImpl.REFRESH_TOKEN, issuedDate, expiredDate);
    }
}
