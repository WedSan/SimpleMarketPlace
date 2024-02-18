package wedsan.simplemarketplace.infrastructure.gateway;

import org.springframework.stereotype.Service;
import wedsan.simplemarketplace.application.usecase.gateway.ShopkeeperGateway;
import wedsan.simplemarketplace.core.domain.Shopkeeper;
import wedsan.simplemarketplace.infrastructure.entity.ShopkeeperEntity;
import wedsan.simplemarketplace.infrastructure.persistence.ShopkeeperRepository;

@Service
public class ShopkeeperRepositoryGateway implements ShopkeeperGateway {

    private final ShopkeeperRepository shopkeeperRepository;

    private final ShopkeeperEntityMapper shopkeeperEntityMapper;

    public ShopkeeperRepositoryGateway(ShopkeeperRepository shopkeeperRepository, ShopkeeperEntityMapper shopkeeperEntityMapper) {
        this.shopkeeperRepository = shopkeeperRepository;
        this.shopkeeperEntityMapper = shopkeeperEntityMapper;
    }

    @Override
    public Shopkeeper save(Shopkeeper shopkeeper) {
        ShopkeeperEntity shopkeeperEntityToBeSaved = this.shopkeeperEntityMapper.toEntity(shopkeeper);
        ShopkeeperEntity shopkeeperEntitySaved = this.shopkeeperRepository.save(shopkeeperEntityToBeSaved);
        return this.shopkeeperEntityMapper.toDomainObj(shopkeeperEntitySaved);
    }

    @Override
    public boolean existsByDocument(String document) {
        return this.shopkeeperRepository.existsByDocument(document);
    }


}
