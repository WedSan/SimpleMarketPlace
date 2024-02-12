package wedsan.simplemarketplace.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import wedsan.simplemarketplace.core.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{
}
