package wedsan.simplemarketplace.core.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Customer extends User {

    public Customer(){}

    public Customer(String name, CustomerDocument document, String email, String password, Set<UserRole> userRoles, Address address){
        super(name, document, email, password,userRoles, address);
    }

    public Customer(Long id, String name, CustomerDocument document, String email, String password, Set<UserRole> userRoles, Address address) {
        super(id, name, document, email, password, userRoles, address);
    }
}