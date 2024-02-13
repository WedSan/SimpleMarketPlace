package wedsan.simplemarketplace.core.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Seller extends User{

    private BigDecimal accountBalance;

    public Seller() {
        super();
    }

    public Seller(Long id, String name, String document, String email, Address address) {
        super(id, name, document, email, address);
        this.accountBalance = new BigDecimal(0);
    }

    public BigDecimal getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }
}
