package wedsan.simplemarketplace.infrastructure.gateway;

import org.springframework.stereotype.Service;
import wedsan.simplemarketplace.application.usecase.gateway.ShopkeeperGateway;
import wedsan.simplemarketplace.core.domain.Shopkeeper;
import wedsan.simplemarketplace.infrastructure.persistence.UserRepository;

@Service
public class ShopkeeperRepositoryGateway implements ShopkeeperGateway {

    private UserRepository userRepository;

    public ShopkeeperRepositoryGateway(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Shopkeeper save(Shopkeeper shopkeeper) {
        return null;
    }

    public ShopkeeperRepositoryGateway() {
    }
}
