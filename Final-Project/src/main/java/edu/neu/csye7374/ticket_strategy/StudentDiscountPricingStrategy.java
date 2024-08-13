package edu.neu.csye7374.ticket_strategy;

public class StudentDiscountPricingStrategy implements PricingStrategy {
    private final double discountRate;

    public StudentDiscountPricingStrategy(double discountRate) {
        this.discountRate = discountRate;
    }

    @Override
    public double calculatePrice(double basePrice) {
        return basePrice * (1 - discountRate);
    }
}