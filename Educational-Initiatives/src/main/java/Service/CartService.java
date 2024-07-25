package Service;

import Models.Cart;
import Models.Product;
import Repository.ProductRepository;
import Strategy.DiscountStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CartService {
    private Map<String, Cart> cartItems = new HashMap<>();
    private DiscountStrategy discountStrategy;

    @Autowired
    private ProductRepository productRepository;

    public void addProduct(Long productId) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product not found"));
        cartItems.putIfAbsent(product.getName(), new Cart(product.clone(), 0));
        cartItems.get(product.getName()).setQuantity(cartItems.get(product.getName()).getQuantity() + 1);
    }

    public void updateQuantity(String productName, int quantity) {
        if (cartItems.containsKey(productName)) {
            cartItems.get(productName).setQuantity(quantity);
        }
    }

    public void removeProduct(String productName) {
        cartItems.remove(productName);
    }

    public double calculateTotalBill() {
        return cartItems.values().stream()
                .mapToDouble(item -> item.getProduct().getPrice() * item.getQuantity())
                .sum();
    }

    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public double applyDiscount() {
        return discountStrategy.applyDiscount(calculateTotalBill());
    }

    public Map<String, Cart> getCartItems() {
        return cartItems;
    }
}
