package Assn_2025_11_15.service;

import Assn_2025_11_15.exception.DuplicateEntryException;
import Assn_2025_11_15.model.Customer;

import java.util.HashMap;
import java.util.Map;

public class CustomerService {
    private HashMap<Integer, Customer> customerMap = new HashMap<>();

    public void addCustomer(Customer customer) throws DuplicateEntryException {
        if (customerMap.containsKey(customer.getId())) {
            System.out.println("Customer ID already exists!");
            throw new DuplicateEntryException("A Customer with ID " + customer.getId() + " already exists!");

        }
        customerMap.put(customer.getId(), customer);
        System.out.println("Customer added successfully!");
    }

    public void viewCustomers() {
        if (customerMap.isEmpty()) {
            System.out.println("No customers available!");
            return;
        }
        System.out.println("\n--- CUSTOMER LIST ---");
        for (Map.Entry<Integer, Customer> entry : customerMap.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

    public void updateCustomer(int id, String name, String phoneNumber) {
        Customer customer = customerMap.get(id);
        if (customer == null) {
            System.out.println("Customer not found!");
            return;
        }
        customer.setName(name);
        customer.setPhoneNumber(phoneNumber);
        System.out.println("Customer updated successfully!");
    }

    public void deleteCustomer(int id) {
        if (customerMap.remove(id) != null) {
            System.out.println("Customer deleted successfully!");
        } else {
            System.out.println("Customer not found!");
        }
    }
}
