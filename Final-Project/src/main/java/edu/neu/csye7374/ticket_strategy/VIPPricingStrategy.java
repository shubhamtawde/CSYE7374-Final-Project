package edu.neu.csye7374.ticket_strategy;

public class VIPPricingStrategy implements PricingStrategy {
    private final double vipMarkup;

    public VIPPricingStrategy(double vipMarkup) {
        this.vipMarkup = vipMarkup;
    }

    @Override
    public double calculatePrice(double basePrice) {
        return basePrice * (1 + vipMarkup);
    }
}