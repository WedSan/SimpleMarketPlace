package wedsan.simplemarketplace.infrastructure.entity.security;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import wedsan.simplemarketplace.infrastructure.entity.UserEntity;

import java.util.List;
import java.util.UUID;

@Entity(name = "tb_refresh_token")
public class RefreshTokenEntity {

    @Id
    private Long userID;

    @Column(name = "refresh_token", nullable = false, length = 255)
    private String refreshToken;

    public RefreshTokenEntity(){}

    public RefreshTokenEntity(Long userID, String refreshToken) {
        this.userID = userID;
        this.refreshToken = refreshToken;
    }

    public Long getUserID() {
        return userID;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }
}
