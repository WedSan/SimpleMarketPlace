package wedsan.simplemarketplace.core.domain;

import java.math.BigDecimal;
import java.util.List;

public class Seller extends User{

    private List<Product> productsListSeller;

    private BigDecimal accountBalance;

    public Seller() {}

    public Seller(long id, String name, String document, List<Product> productsListSeller) {
        super(id, name, document);
        this.productsListSeller = productsListSeller;
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
