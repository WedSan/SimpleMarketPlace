package wedsan.simplemarketplace.infrastructure.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import wedsan.simplemarketplace.core.domain.UserRole;
import wedsan.simplemarketplace.infrastructure.entity.Address.AddressEntity;

import java.util.Set;

@Entity
@Table(name = "tb_shopkeeper")
public class ShopkeeperEntity extends UserEntity{
    public ShopkeeperEntity() {
    }

    public ShopkeeperEntity(Long id, String name, String document, String email, String password, Set<UserRole> userRoles, AddressEntity address) {
        super(id, name, document, email, password, userRoles, address);
    }

}
