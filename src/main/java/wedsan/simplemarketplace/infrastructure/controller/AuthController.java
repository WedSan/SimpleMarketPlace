package wedsan.simplemarketplace.infrastructure.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wedsan.simplemarketplace.application.usecase.LogInUseCase;
import wedsan.simplemarketplace.core.domain.AuthLogin;
import wedsan.simplemarketplace.infrastructure.dto.request.AuthLoginRequest;
import wedsan.simplemarketplace.infrastructure.security.JWTService;

@RestController
@RequestMapping("api/auth")
public class AuthController {

    private LogInUseCase logInUseCase;

    public AuthController(LogInUseCase logInUseCase) {
        this.logInUseCase = logInUseCase;
    }

    @PostMapping("login")
    public ResponseEntity<Object> logIn(@RequestBody AuthLoginRequest loginRequest){
        try{
            AuthLogin login = new AuthLogin(loginRequest.email(), loginRequest.password());
            logInUseCase.verifyUserCredentials(login);
            return ResponseEntity.ok().body(logInUseCase.generateTokens(login));
        }catch(AuthenticationException ex){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invaid Credentials: "+ex.getMessage());
        }
    }
}
