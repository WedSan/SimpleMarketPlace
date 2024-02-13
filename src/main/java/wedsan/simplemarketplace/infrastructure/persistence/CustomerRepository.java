package wedsan.simplemarketplace.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wedsan.simplemarketplace.core.domain.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{
}
