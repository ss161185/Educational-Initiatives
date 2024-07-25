package Models;

import jakarta.persistence.*;

@Entity
@Table(name="Cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cartID;

    @Column
    private Product product;

    @Column
    private int quantity;

    public Cart() {}

    public Cart(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    // Getters and Setters

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
