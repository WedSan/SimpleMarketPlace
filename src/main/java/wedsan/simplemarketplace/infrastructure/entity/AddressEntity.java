package wedsan.simplemarketplace.infrastructure.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_address")
public class AddressEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String zipCode;

    private String streetAddress;

    private String city;

    private String Province;

    private String addressNumber;
}
