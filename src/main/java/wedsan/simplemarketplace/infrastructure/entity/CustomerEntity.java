package wedsan.simplemarketplace.infrastructure.entity;

import jakarta.persistence.*;
import wedsan.simplemarketplace.core.domain.Product;

import java.util.List;
@Entity
@Table(name = "tb_customer")
public class CustomerEntity extends UserEntity{

    public CustomerEntity() {
    }

    public CustomerEntity(Long id, String name, String document, String email, AddressEntity address) {
        super(id, name, document, email, address);
    }
}
