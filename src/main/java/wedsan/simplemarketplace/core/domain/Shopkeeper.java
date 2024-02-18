package wedsan.simplemarketplace.core.domain;

import java.math.BigDecimal;
import java.util.List;

public class Shopkeeper extends User{

    private List<Product> productsListSeller;

    private BigDecimal accountBalance;

    public Shopkeeper() {
        super();
    }

    public Shopkeeper(Long id, String name, ShopkeeperDocument document, String email, Address address, List<Product> productsListSeller) {
        super(id, name, document, email, address);
        this.productsListSeller = productsListSeller;
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
