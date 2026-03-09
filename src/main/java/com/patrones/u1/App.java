package com.patrones.u1;

import java.util.List;

public class App
{
    public static void main( String[] args ) {
        OrderRepository repo        = new OrderRepository();
        EmailNotifier   notifier    = new EmailNotifier();
        TaxCalculator   calc        = new TaxCalculator(0.19);
        OrderReport     reporter    = new OrderReport();

        // Orden con cliente VIP
        OrderService vipService = new OrderService(calc, notifier, repo,
            new VipDiscount());
        vipService.processOrder( "ORD-001", "vip@mail.com",
            List.of(100.0, 200.0, 50.0));

        // Orden con cliente Regular
        OrderService regService = new OrderService(calc, notifier, repo,
            new RegularDiscount());
        regService.processOrder("ORD-002", "reg@mail.com",
            List.of(80.0, 120.0));

        reporter.print(repo.findAll());
    }
}
