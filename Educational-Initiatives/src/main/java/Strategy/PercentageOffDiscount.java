package Strategy;

import org.springframework.stereotype.Component;

@Component
public class PercentageOffDiscount implements DiscountStrategy {
    private final double percentage;

    public PercentageOffDiscount(double percentage) {
        this.percentage = percentage;
    }

    @Override
    public double applyDiscount(double totalBill) {
        return totalBill - (totalBill * percentage / 100);
    }
}

