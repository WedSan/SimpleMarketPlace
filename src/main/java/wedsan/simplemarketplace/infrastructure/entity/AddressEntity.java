package wedsan.simplemarketplace.infrastructure.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import wedsan.simplemarketplace.core.domain.Address;

@Entity
@Table(name = "tb_address")
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String zipCode;

    @NotNull
    private String streetAddress;

    @NotNull
    @OneToOne(cascade = CascadeType.PERSIST)
    private CityEntity city;

    @NotNull
    @OneToOne(cascade = CascadeType.PERSIST)
    private ProvinceEntity province;
    @NotNull
    private String addressNumber;

    public AddressEntity(){}

    public AddressEntity(Long id, String zipCode, String streetAddress, CityEntity city, ProvinceEntity province, String addressNumber) {
        this.id = id;
        this.zipCode = zipCode;
        this.streetAddress = streetAddress;
        this.city = city;
        this.province = province;
        this.addressNumber = addressNumber;
    }

    public AddressEntity(Address address){
       this.zipCode = address.getZipCode();
       this.streetAddress = address.getStreetAddress();
       this.city = new CityEntity(address.getCity());
       this.province = new ProvinceEntity(address.getProvince());
       this.addressNumber = address.getAddressNumber();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public CityEntity getCity() {
        return city;
    }

    public void setCity(CityEntity city) {
        this.city = city;
    }

    public ProvinceEntity getProvince() {
        return province;
    }

    public void setProvince(ProvinceEntity province) {
        this.province = province;
    }

    public String getAddressNumber() {
        return addressNumber;
    }

    public void setAddressNumber(String addressNumber) {
        this.addressNumber = addressNumber;
    }
}
