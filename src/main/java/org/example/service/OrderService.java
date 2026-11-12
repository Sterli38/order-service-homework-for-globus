package org.example.service;

import org.example.commission.CommissionFactory;
import org.example.discount.DiscountFactory;
import org.example.model.Order;
import org.example.receipt.ReceiptPrinter;
import org.example.repository.OrderRepository;
import org.example.validation.OrderValidator;

/**
 * Контекст: Тебе достался в наследство код от предыдущего разработчика — сервис обработки заказов интернет-магазина OrderService.
 * Он работает, тесты (если бы они были) прошли бы, заказчик доволен... пока не попросил добавить новый тип клиента или способ оплаты.
 * Тут выясняется, что каждое такое "простое" изменение требует лезть в один и тот же метод на 80 строк, где всё завязано друг на друга,
 * и есть риск что-то сломать в соседней логике.
 * Твоя задача: не переписать сервис с нуля, а отрефакторить — сохранив то же поведение (те же скидки, та же комиссия, тот же чек)
 * Опирайся на SOLID и паттерны проектирования
 * Lombok использовать нельзя, все писать руками.
 */
public class OrderService {
    private final OrderValidator orderValidator;
    private final OrderRepository orderRepository;
    private final ReceiptPrinter receiptPrinter;
    private final DiscountFactory discountFactory;
    private final CommissionFactory commissionFactory;

    public OrderService(OrderValidator orderValidator,
                        OrderRepository orderRepository,
                        ReceiptPrinter receiptPrinter,
                        DiscountFactory discountFactory,
                        CommissionFactory commissionFactory) {
        this.orderValidator = orderValidator;
        this.orderRepository = orderRepository;
        this.receiptPrinter = receiptPrinter;
        this.discountFactory = discountFactory;
        this.commissionFactory = commissionFactory;
    }

    private double calculateDiscount(Order order) {
        return discountFactory.getDiscountStrategy(order.getCustomerType()).calculateDiscount(order);
    }

    private double calculateCommission(Order order) {
        return commissionFactory.getCommissionStrategy(order.getPaymentType()).calculateCommission(order);
    }

    public double processOrder(Order order) {
        orderValidator.validate(order);

        double discount = calculateDiscount(order);
        double commission = calculateCommission(order);
        double finalAmount = order.getAmount() - discount + commission;

        receiptPrinter.printCheck(order, discount, commission, finalAmount);

        orderRepository.saveOrder(order);

        return finalAmount;
    }
}

