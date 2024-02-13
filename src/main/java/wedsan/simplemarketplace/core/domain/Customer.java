package wedsan.simplemarketplace.core.domain;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User {

    private List<Product> shoppingCart;

    public Customer(){}

    public Customer(String name, String document, String email, Address address, List<Product> list){
        super(name, document, email, address);
        this.shoppingCart = list;
    }

    public Customer(Long id, String name, String document, String email, Address address, List<Product> list) {
        super(id, name, document, email, address);
        this.shoppingCart = list;
    }

}