package wedsan.simplemarketplace.infrastructure.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import wedsan.simplemarketplace.infrastructure.entity.Address.AddressEntity;

@Entity
@Table(name = "tb_shopkeeper")
public class ShopkeeperEntity extends UserEntity{
    public ShopkeeperEntity() {
    }

    public ShopkeeperEntity(Long id, String name, String document, String email, AddressEntity address) {
        super(id, name, document, email, address);
    }

}
