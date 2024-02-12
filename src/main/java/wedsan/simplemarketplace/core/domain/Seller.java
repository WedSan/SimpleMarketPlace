package wedsan.simplemarketplace.core.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Seller extends User{

    private List<Product> productsListSeller;

    private BigDecimal accountBalance;

    public Seller() {
        super();
    }

    public Seller(Long id, String name, String document, String email, Address address) {
        super(id, name, document, email, address);
        this.productsListSeller = new ArrayList<>();
        this.accountBalance = new BigDecimal(0);
    }

    public List<Product> getProductsListSeller() {
        return productsListSeller;
    }

    public void setProductsListSeller(List<Product> productsListSeller) {
        this.productsListSeller = productsListSeller;
    }

    public BigDecimal getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }
}
