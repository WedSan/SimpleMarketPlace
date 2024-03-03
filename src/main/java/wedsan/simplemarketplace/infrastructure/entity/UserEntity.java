package wedsan.simplemarketplace.infrastructure.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import wedsan.simplemarketplace.core.domain.UserRole;
import wedsan.simplemarketplace.infrastructure.entity.Address.AddressEntity;

import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String document;
    @NotNull
    private String email;
    @NotNull
    @ElementCollection(targetClass = UserRole.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role")
    private Set<UserRole> userRoles;
    @NotNull
    private String password;
    @NotNull
    @OneToOne(cascade = CascadeType.PERSIST)
    private AddressEntity address;

    public UserEntity(){}

    public UserEntity(Long id, String name, String document, String email, String password, Set<UserRole> userRoles, AddressEntity address) {
        this.id = id;
        this.name = name;
        this.document = document;
        this.email = email;
        this.password = password;
        this.userRoles = userRoles;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AddressEntity getAddress() {
        return address;
    }

    public void setAddress(AddressEntity address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<UserRole> userRole) {
        this.userRoles = userRole;
    }
}
