package wedsan.simplemarketplace.infrastructure.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class JWTKey {

    private final String KEY;

   public JWTKey(@Value("${SECURITY_KEY}") String keyFromProperty){
       if(keyFromProperty == null){
           throw new RuntimeException("Security Key was not found!");
       }
       this.KEY = keyFromProperty;
   }

   public String getKEY(){
       return this.KEY;
    }
}
