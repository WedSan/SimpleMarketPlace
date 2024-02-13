package wedsan.simplemarketplace.infrastructure.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import wedsan.simplemarketplace.core.domain.Address;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "tb_user")
public abstract class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String document;
    @NotNull
    private String email;
    @NotNull
    @OneToOne
    private AddressEntity address;

    public UserEntity(){}

    public UserEntity(Long id, String name, String document, String email, AddressEntity address) {
        this.id = id;
        this.name = name;
        this.document = document;
        this.email = email;
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
}
