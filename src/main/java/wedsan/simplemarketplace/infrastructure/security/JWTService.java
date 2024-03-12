package wedsan.simplemarketplace.infrastructure.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.stereotype.Service;
import wedsan.simplemarketplace.application.usecase.gateway.TokenGeneratorGateway;
import wedsan.simplemarketplace.core.domain.TokenType;

import java.util.Date;

@Service
public class JWTService implements TokenGeneratorGateway {

    private final JWTKey jwtKey;

    public JWTService(JWTKey jwtKey) {
        this.jwtKey = jwtKey;
    }

    @Override
    public String generateToken(String subject) {
        return generateToken(subject, TokenTypeImpl.JWT_TOKEN);
    }

    public String generateToken(String subject, TokenTypeImpl tokenType, Date issuedDate, Date expirationTime)  {
        String password = jwtKey.getKEY();

        return JWT.create()
                .withSubject(subject)
                .withIssuedAt(issuedDate)
                .withExpiresAt(expirationTime)
                .withClaim("TokenType", tokenType.getLabel())
                .sign(Algorithm.HMAC256(password));
    }

    public String generateToken(String subject, TokenType tokenType)  {
        String password = jwtKey.getKEY();
        Date tokenExpirationTime = getExpirationTime(3600);

        return JWT.create()
                .withSubject(subject)
                .withIssuedAt(new Date())
                .withExpiresAt(tokenExpirationTime)
                .withClaim("TokenType", tokenType.getLabel())
                .sign(Algorithm.HMAC256(password));
    }

    public String getSubject(String token){
        String password = jwtKey.getKEY();
        return JWT.require(Algorithm.HMAC256(password))
                .build()
                .verify(token)
                .getSubject();
    }

    public boolean isTokenValid(String token){
        String password = jwtKey.getKEY();

        try{
            JWT.require(Algorithm.HMAC256(password))
                    .build()
                    .verify(token);
            return true;
        } catch(JWTVerificationException ex){
            return false;
        }
    }


    private Date getExpirationTime(int secondsToAdd){
        Date currentDate = new Date();
        return Date.from(currentDate.toInstant().plusSeconds(secondsToAdd));
    }




}
