package wedsan.simplemarketplace.core.domain;

import java.util.List;

public class ShoppingCart {

    private Long id;

    List<Product> products;

    private Customer customer;

    public ShoppingCart() {}

    public ShoppingCart(Long id, List<Product> products, Customer customer) {
        this.id = id;
        this.products = products;
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
