package com.patrones.u1;

import java.util.List;

public class TaxtCalculator {
    private final double taxRate;

    public TaxtCalculator(double taxRate) {
        this.taxRate = taxRate;
    }

    public double calculateTotal(List<Double> prices) {
        double subtotal =
            prices.stream().mapToDouble(Double::doubleValue).sum();
        return subtotal + (subtotal * taxRate);
    }
}
