package wedsan.simplemarketplace.application.usecase.impl;

import wedsan.simplemarketplace.application.usecase.CreateShopkeeperUseCase;
import wedsan.simplemarketplace.application.usecase.gateway.PasswordEncoderGateway;
import wedsan.simplemarketplace.application.usecase.gateway.ShopkeeperGateway;
import wedsan.simplemarketplace.core.domain.Shopkeeper;
import wedsan.simplemarketplace.core.domain.UserValidator;
import wedsan.simplemarketplace.infrastructure.persistence.UserRepository;

import java.util.List;

public class CreateShopkeeperUseCaseImpl implements CreateShopkeeperUseCase {

    private ShopkeeperGateway shopkeeperGateway;

    private List<UserValidator> userValidatorList;

    private PasswordEncoderGateway passwordEncoderGateway;

    public CreateShopkeeperUseCaseImpl(ShopkeeperGateway shopkeeperGateway, List<UserValidator> userValidatorList, PasswordEncoderGateway passwordEncoderGateway) {
        this.shopkeeperGateway = shopkeeperGateway;
        this.userValidatorList = userValidatorList;
        this.passwordEncoderGateway = passwordEncoderGateway;
    }

    @Override
    public Shopkeeper create(Shopkeeper shopkeeper) {
        userValidatorList.forEach(userValidator -> userValidator.validate(shopkeeper));
        String passwordEncoded = passwordEncoderGateway.encode(shopkeeper.getPassword());
        shopkeeper.setPassword(passwordEncoded);
        return this.shopkeeperGateway.save(shopkeeper);
    }
}
