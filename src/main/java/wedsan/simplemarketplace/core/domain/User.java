package wedsan.simplemarketplace.core.domain;

public abstract class User {

    private Long id;

    private String name;

    private UserDocument document;

    private String email;

    private String password;

    private Address address;

    public User(){}


    public User(String name, UserDocument document, String email, String password, Address address) {
        this.name = name;
        this.document = document;
        this.email = email;
        this.password = password;
        this.address = address;
    }

    public User(Long id, String name, UserDocument document, String email, String password, Address address) {
        this.id = id;
        this.name = name;
        this.document = document;
        this.email = email;
        this.password = password;
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

    public UserDocument getDocument() {
        return document;
    }

    public void setDocument(UserDocument document) {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
