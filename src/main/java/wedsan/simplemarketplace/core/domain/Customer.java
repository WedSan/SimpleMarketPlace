package wedsan.simplemarketplace.core.domain;

import java.util.List;

public class Customer extends User {

    private List<Product> shoppingCart;

    public Customer(){}
    public Customer(long id, String name, String document, List<Product> shoppingCart) {
        super(id, name, document);
        this.shoppingCart = shoppingCart;
    }



}