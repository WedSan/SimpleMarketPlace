package wedsan.simplemarketplace.infrastructure.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import wedsan.simplemarketplace.core.domain.Product;

import java.util.List;

@Table(name = "tb_customer")
public class CustomerEntity extends UserEntity{

}
