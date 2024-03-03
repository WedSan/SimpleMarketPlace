package wedsan.simplemarketplace.infrastructure.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.time.Instant;
import java.util.Date;

@Service
public class JWTService {

    private final JWTKey jwtKey;

    public JWTService(JWTKey jwtKey) {
        this.jwtKey = jwtKey;
    }

    private String generateToken(String subject) throws NoSuchAlgorithmException {
        String password = jwtKey.getKEY();
        Instant expirationTime = getExpirationTime();

        return JWT.create()
                .withSubject(subject)
                .withIssuedAt(new Date())
                .withExpiresAt(expirationTime)
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

    private Instant getExpirationTime(){
        Date currentDate = new Date();
        return currentDate.toInstant().plusSeconds(10000);
    }




}
