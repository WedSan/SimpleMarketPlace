package wedsan.simplemarketplace.core.domain;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User {

    private List<Product> shoppingCart;

    public Customer(){}


    public Customer(long id, String name, String document, String email, Address address) {
        super(id, name, document, email, address);
        this.shoppingCart = new ArrayList<>();
    }
}