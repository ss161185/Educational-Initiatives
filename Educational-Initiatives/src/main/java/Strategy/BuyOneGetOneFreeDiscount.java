package Strategy;

import org.springframework.stereotype.Component;

@Component
public class BuyOneGetOneFreeDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double totalBill) {
        // Simplified logic for BOGO
        return totalBill / 2;
    }
}