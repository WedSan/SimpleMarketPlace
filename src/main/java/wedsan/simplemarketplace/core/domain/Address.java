package wedsan.simplemarketplace.core.domain;

public class Address {

    private Long id;

    private String zipCode;

    private String streetAddress;

    private String city;

    private String province;

    private String addressNumber;

    public Address(){}

    public Address(Long id, String zipCode, String streetAddress, String city, String province, String addressNumber) {
        this.id = id;
        this.zipCode = zipCode;
        this.streetAddress = streetAddress;
        this.city = city;
        this.province = province;
        this.addressNumber = addressNumber;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getAddressNumber() {
        return addressNumber;
    }

    public void setAddressNumber(String addressNumber) {
        this.addressNumber = addressNumber;
    }
}
