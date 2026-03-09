package com.patrones.u1.entities.discounts;

public class VipDiscount implements DiscountStrategy {
    @Override
    public double apply(double total) { return total * 0.85; }
}
