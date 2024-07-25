package Controllers;

import Models.Cart;
import Service.CartService;
import Strategy.BuyOneGetOneFreeDiscount;
import Strategy.PercentageOffDiscount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/add")
    public void addProduct(@RequestParam Long productId) {
        cartService.addProduct(productId);
    }

    @PutMapping("/update")
    public void updateQuantity(@RequestParam String productName, @RequestParam int quantity) {
        cartService.updateQuantity(productName, quantity);
    }

    @DeleteMapping("/remove")
    public void removeProduct(@RequestParam String productName) {
        cartService.removeProduct(productName);
    }

    @GetMapping("/total")
    public double getTotalBill() {
        return cartService.calculateTotalBill();
    }

    @GetMapping("/applyDiscount")
    public double applyDiscount(@RequestParam String discountType) {
        // Simplified example: dynamically setting discount strategy
        if ("percentage".equals(discountType)) {
            cartService.setDiscountStrategy(new PercentageOffDiscount(10));
        } else if ("bogo".equals(discountType)) {
            cartService.setDiscountStrategy(new BuyOneGetOneFreeDiscount());
        }
        return cartService.applyDiscount();
    }

    @GetMapping("/items")
    public Map<String, Cart> getCartItems() {
        return cartService.getCartItems();
    }
}
