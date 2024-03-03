package wedsan.simplemarketplace.infrastructure.entity;

import jakarta.persistence.*;
import wedsan.simplemarketplace.core.domain.UserRole;
import wedsan.simplemarketplace.infrastructure.entity.Address.AddressEntity;

import java.util.Set;

@Entity
@Table(name = "tb_customer")
public class CustomerEntity extends UserEntity{

    public CustomerEntity() {
    }

    public CustomerEntity(Long id, String name, String document, String email, String password, Set<UserRole> userRoles, AddressEntity address) {
        super(id, name, document, email, password, userRoles, address);
    }
}
