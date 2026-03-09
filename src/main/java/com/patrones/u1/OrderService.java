package com.patrones.u1;

import java.util.List;

public class OrderService {
    private final TaxCalculator     taxCalculator;
    private final EmailNotifier     emailNotifier;
    private final OrderRepository   orderRepository;
    private final DiscountStrategy  discountStrategy;

    // Inyeccion por constructor - DIP aplicado
    public OrderService(
            TaxCalculator       taxCalculator,
            EmailNotifier       emailNotifier,
            OrderRepository     orderRepository,
            DiscountStrategy    discountStrategy
    ) {
        this.taxCalculator      = taxCalculator;
        this.emailNotifier      = emailNotifier;
        this.orderRepository    = orderRepository;
        this.discountStrategy   = discountStrategy;
    }

    public void processOrder(
            String orderId, String email, List<Double> prices
    ) {
        double total        = taxCalculator.calculateTotal(prices);
        double discounted   = discountStrategy.apply(total);

        orderRepository.save(orderId, discounted);
        emailNotifier.sendConfirmation(email, orderId);
    }
}
