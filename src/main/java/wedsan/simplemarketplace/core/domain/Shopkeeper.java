package wedsan.simplemarketplace.core.domain;

import java.math.BigDecimal;
import java.util.List;

public class Shopkeeper extends User{

    public Shopkeeper() {
        super();
    }

    public Shopkeeper(Long id, String name, ShopkeeperDocument document, String email, String password, Address address) {
        super(id, name, document, email, password, address);
    }

}
