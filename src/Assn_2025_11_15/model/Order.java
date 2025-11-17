package Assn_2025_11_15.model;

import java.util.LinkedList;

public class Order {
    private int orderId;
    private int customerId;
    private LinkedList<String> menuItems;

    public Order(int orderId, int customerId) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.menuItems = new LinkedList<>();
    }

    public int getOrderId() {
        return orderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public LinkedList<String> getMenuItems() {
        return menuItems;
    }

    public void addMenuItem(String item) {
        menuItems.add(item);
    }

    public void removeMenuItem(String item) {
        menuItems.remove(item);
    }

    @Override
    public String toString() {
        return "Order ID: " + orderId +
                " | Customer ID: " + customerId +
                " | Items: " + menuItems;
    }
}
