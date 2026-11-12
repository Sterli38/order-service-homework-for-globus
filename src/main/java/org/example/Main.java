package org.example;

import org.example.commission.CommissionFactory;
import org.example.discount.DiscountFactory;
import org.example.model.Order;
import org.example.receipt.ReceiptPrinter;
import org.example.repository.OrderRepository;
import org.example.service.OrderService;
import org.example.validation.OrderValidator;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        OrderService service = new OrderService(new OrderValidator(), new OrderRepository(), new ReceiptPrinter(),
                new DiscountFactory(), new CommissionFactory());

        Order order1 = new Order("1", "VIP", "CARD", List.of("Laptop", "Mouse"), 1000.0);
        Order order2 = new Order("2", "REGULAR", "CASH", List.of("Book"), 20.0);

        System.out.println("Final amount 1: " + service.processOrder(order1));
        System.out.println("Final amount 2: " + service.processOrder(order2));
    }
}