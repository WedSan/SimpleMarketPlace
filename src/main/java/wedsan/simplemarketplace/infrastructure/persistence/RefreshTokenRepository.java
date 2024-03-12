package wedsan.simplemarketplace.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import wedsan.simplemarketplace.infrastructure.entity.security.RefreshTokenEntity;

import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshTokenEntity, Long> {

    Optional<RefreshTokenEntity> findByRefreshToken(String refreshToken);

}
