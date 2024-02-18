package wedsan.simplemarketplace.infrastructure.entity;

import jakarta.persistence.*;
import wedsan.simplemarketplace.infrastructure.entity.Address.AddressEntity;

@Entity
@Table(name = "tb_customer")
public class CustomerEntity extends UserEntity{

    public CustomerEntity() {
    }

    public CustomerEntity(Long id, String name, String document, String email, AddressEntity address) {
        super(id, name, document, email, address);
    }
}
