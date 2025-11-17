package Assn_2025_11_15.service;

import Assn_2025_11_15.exception.DuplicateEntryException;
import Assn_2025_11_15.model.Order;

import java.util.HashMap;

public class OrderService {
    private HashMap<Integer, Order> orderMap = new HashMap<>();

    // Create new order
    public void createOrder(Order order) throws DuplicateEntryException {
        if (orderMap.containsKey(order.getOrderId())) {
            System.out.println("Order ID already exists!");
            throw new DuplicateEntryException("Order Item ID " + order.getOrderId() + " already exists!");
        }
        orderMap.put(order.getOrderId(), order);
        System.out.println("Order created successfully!");
    }

    // View all orders
    public void viewOrders() {
        if (orderMap.isEmpty()) {
            System.out.println("No orders available!");
            return;
        }
        System.out.println("\n--- EXISTING ORDERS ---");
        for (Order order : orderMap.values()) {
            System.out.println(order);
        }
    }

    // Update order by adding/removing menu items
    public void updateOrder(int orderId, boolean add, String item) {
        Order order = orderMap.get(orderId);
        if (order == null) {
            System.out.println("Order not found!");
            return;
        }
        if (add) {
            order.addMenuItem(item);
            System.out.println("Item added to order!");
        } else {
            order.removeMenuItem(item);
            System.out.println("Item removed from order!");
        }
    }

    // Cancel an order
    public void cancelOrder(int orderId) {
        if (orderMap.remove(orderId) != null) {
            System.out.println("Order cancelled successfully!");
        } else {
            System.out.println("Order not found!");
        }
    }
}
