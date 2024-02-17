package wedsan.simplemarketplace.core.domain;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User {

    public Customer(){}

    public Customer(String name, CustomerDocument document, String email, Address address){
        super(name, document, email, address);
    }

    public Customer(Long id, String name, CustomerDocument document, String email, Address address) {
        super(id, name, document, email, address);
    }
}