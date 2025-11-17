package Assn_2025_11_15.view;

import Assn_2025_11_15.exception.DuplicateEntryException;
import Assn_2025_11_15.model.Order;
import Assn_2025_11_15.service.OrderService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class OrderView {
    public static void showMenu(Scanner sc, OrderService manager) {
        int choice;
        do {
            System.out.println("\n########## ORDER MANAGEMENT ##########");
            System.out.println("1. Create New Order");
            System.out.println("2. View All Orders");
            System.out.println("3. Update Order (Add/Remove Items)");
            System.out.println("4. Cancel Order");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    try {
                        System.out.print("Enter Order ID: ");
                        int orderId = sc.nextInt();
                        System.out.print("Enter Customer ID: ");
                        int customerId = sc.nextInt();
                        Order order = new Order(orderId, customerId);
                        sc.nextLine();

                        System.out.print("Enter number of menu items: ");
                        int count = sc.nextInt();
                        sc.nextLine();

                        for (int i = 0; i < count; i++) {
                            System.out.print("Enter item name " + (i + 1) + ": ");
                            String item = sc.nextLine();
                            order.addMenuItem(item);
                        }
                        manager.createOrder(order);
                    } catch (DuplicateEntryException e) {
                        System.out.println("⚠️ " + e.getMessage());
                    } catch (InputMismatchException e) {
                        System.out.println("⚠️ Invalid input! Order already exist");
                        sc.nextLine(); // clear invalid input
                    }
                }

                case 2 -> manager.viewOrders();

                case 3 -> {
                    System.out.print("Enter Order ID: ");
                    int orderId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter item name: ");
                    String item = sc.nextLine();
                    System.out.print("Add or Remove? (a/r): ");
                    char action = sc.next().charAt(0);
                    manager.updateOrder(orderId, action == 'a', item);
                }

                case 4 -> {
                    System.out.print("Enter Order ID to cancel: ");
                    int orderId = sc.nextInt();
                    manager.cancelOrder(orderId);
                }

                case 5 -> System.out.println("Returning to Main Menu...");
                default -> System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 5);
    }
}
