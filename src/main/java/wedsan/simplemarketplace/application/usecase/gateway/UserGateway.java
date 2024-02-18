package wedsan.simplemarketplace.application.usecase.gateway;

import wedsan.simplemarketplace.core.domain.User;

import java.util.Optional;

public interface UserGateway {

    boolean existsByDocument(String document);

    boolean existsByEmail(String email);
}
