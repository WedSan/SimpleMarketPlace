package wedsan.simplemarketplace.infrastructure.gateway;

import org.springframework.stereotype.Service;
import wedsan.simplemarketplace.application.usecase.gateway.UserGateway;
import wedsan.simplemarketplace.infrastructure.persistence.UserRepository;

//TODO: INSTANCIAR O BEAN DESSE OBJETO
@Service
public class UserGatewayRepository implements UserGateway {
    private final UserRepository userRepository;

    public UserGatewayRepository(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public boolean existsByEmail(String email) {
        return this.userRepository.existsByEmail(email);
    }

    @Override
    public boolean existsByDocument(String document) {
        return this.userRepository.existsByDocument(document);
    }

}
