package wedsan.simplemarketplace.core.domain;

public abstract class User {

    private Long id;

    private String name;

    private String document;

    private String email;

    private Address address;

    public User(){}

    public User(Long id, String name, String document, String email, Address address) {
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
