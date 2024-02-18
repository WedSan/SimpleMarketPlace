package wedsan.simplemarketplace.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import wedsan.simplemarketplace.infrastructure.entity.ShopkeeperEntity;

public interface ShopkeeperRepository extends JpaRepository<ShopkeeperEntity, Long> {

}
