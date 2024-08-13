package edu.neu.csye7374.ticket_strategy;

public class RegularPricingStrategy implements PricingStrategy {
    @Override
    public double calculatePrice(double basePrice) {
        return basePrice;
    }
}
