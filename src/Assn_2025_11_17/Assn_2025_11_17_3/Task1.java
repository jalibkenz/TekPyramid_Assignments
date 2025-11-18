package Assn_2025_11_17.Assn_2025_11_17_3;


//Task 1:
//Implement a program that reads a map of Customer objects from the user and performs the following operations:
//Filter out all customers who have a balance less than the average balance of all customers.
//Calculate the total years of membership of the remaining customers.
//Find the customer with the highest years of membership and return their details.

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

class Customer {
    private String id;
    private String name;
    private String country;
    private int age;
    private int yearsOfMembership;
    private double balance;
    private int loyaltyScore;
    private int numberOfTransactions;

    public Customer(String id, String name, String country, int age, int yearsOfMembership, double balance, int loyaltyScore, int numberOfTransactions) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.age = age;
        this.yearsOfMembership = yearsOfMembership;
        this.balance = balance;
        this.loyaltyScore = loyaltyScore;
        this.numberOfTransactions = numberOfTransactions;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", age=" + age +
                ", yearsOfMembership=" + yearsOfMembership +
                ", balance=" + balance +
                ", loyaltyScore=" + loyaltyScore +
                ", numberOfTransactions=" + numberOfTransactions +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getYearsOfMembership() {
        return yearsOfMembership;
    }

    public void setYearsOfMembership(int yearsOfMembership) {
        this.yearsOfMembership = yearsOfMembership;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getLoyaltyScore() {
        return loyaltyScore;
    }

    public void setLoyaltyScore(int loyaltyScore) {
        this.loyaltyScore = loyaltyScore;
    }

    public int getNumberOfTransactions() {
        return numberOfTransactions;
    }

    public void setNumberOfTransactions(int numberOfTransactions) {
        this.numberOfTransactions = numberOfTransactions;
    }
}

public class Task1 {
    public static void main(String[] args) {

        Map<String, Customer> custMap = new HashMap<>();

        custMap.put("C001", new Customer(
                "1", "Alice", "USA", 28, 5, 1200.50, 80, 23));

        custMap.put("C002", new Customer(
                "2", "Bob", "India", 35, 8, 950.75, 60, 40));

        custMap.put("C003", new Customer(
                "3", "Charlie", "UK", 42, 12, 1500.00, 90, 55));

        custMap.put("C004", new Customer(
                "4", "Diana", "Germany", 31, 3, 700.00, 40, 18));

        custMap.put("C005", new Customer(
                "5", "Ethan", "Canada", 26, 2, 500.25, 30, 12));

        custMap.put("C006", new Customer(
                "6", "Fatima", "UAE", 38, 10, 2000.00, 95, 60));

        custMap.put("C007", new Customer(
                "7", "George", "Australia", 45, 15, 1750.10, 88, 70));

        System.out.println("Customer Map Loaded:");
        //custMap.values().forEach(System.out::println);

        //Implement a program that reads a map of Customer objects from the user and performs the following operations:
        //Filter out all customers who have a balance less than the average balance of all customers.
        //averageBalance
        double avgBalance = custMap.values().stream().mapToDouble(Customer::getBalance).average().orElse(0.0);
        System.out.println("Average Balance "+ avgBalance);

        // map of customers who have balance less than avg bal of all customers
        Map<String, Customer> refinedCustMap = custMap.entrySet().stream()
                .filter(
                        entry ->
                                !(entry.getValue().getBalance() < avgBalance)
                )
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        refinedCustMap.values().forEach(System.out::println);//printing the filtered out output
        //Calculate the total years of membership of the remaining customers.
        int totalYearsOfMembership = refinedCustMap.values().stream().mapToInt(Customer::getYearsOfMembership).sum();
        System.out.println("Total years of Membership: "+totalYearsOfMembership);
        //Find the customer with the highest years of membership and return their details.
        Optional<Customer> customerMaxYearOfMembership = custMap.values().stream()
                .max((c1, c2) -> Integer.compare(c1.getYearsOfMembership(), c2.getYearsOfMembership()));

        // Display the result
        if (customerMaxYearOfMembership.isPresent()) {
            System.out.println("\nCustomer with highest years of membership:");
            System.out.println(customerMaxYearOfMembership.get());
        } else {
            System.out.println("\nNo customers found with balance >= average.");
        }

    }
}
