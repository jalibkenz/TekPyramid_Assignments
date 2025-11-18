package Assn_2025_11_17.Assn_2025_11_17_3;

//Task 2:
//Create a program that takes a map of Customer objects as input and performs the following operations:
//Filter out all customers who have joined in the last 3 years and have a loyalty score less than 4, but have a balance between 2000 and 5000.
//Calculate the sum of the balances of the remaining customers, but only for those who have an even age.
//Find the average age of the remaining customers, but only if their country has more than 10 customers.

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Customer2 {
    private String id;
    private String name;
    private String country;
    private int age;
    private int yearsOfMembership;
    private double balance;
    private int loyaltyScore;
    private int numberOfTransactions;

    public Customer2(String id, String name, String country, int age, int yearsOfMembership, double balance, int loyaltyScore, int numberOfTransactions) {
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

public class Task2 {
    public static void main(String[] args) {

        Map<String, Customer2> custMap = new HashMap<>();
        custMap.put("C001", new Customer2("1", "Alice", "USA", 28, 5, 1200.50, 80, 23));
        custMap.put("C002", new Customer2("2", "Bob", "India", 35, 8, 950.75, 60, 40));
        custMap.put("C003", new Customer2("3", "Charlie", "UK", 42, 12, 1500.00, 90, 55));
        custMap.put("C004", new Customer2("4", "Diana", "Germany", 31, 3, 700.00, 40, 18));
        custMap.put("C005", new Customer2("5", "Ethan", "Canada", 26, 2, 500.25, 30, 12));
        custMap.put("C006", new Customer2("6", "Fatima", "UAE", 38, 10, 2000.00, 95, 60));
        custMap.put("C007", new Customer2("7", "George", "Australia", 45, 15, 1750.10, 88, 70));
        custMap.put("C008", new Customer2("8", "Jalib", "India", 32, 4, 2500.00, 70, 25));
        custMap.put("C009", new Customer2("9", "Mohanlal", "India", 58, 20, 4500.00, 95, 80));
        custMap.put("C010", new Customer2("10", "Prthiviraj", "India", 40, 10, 3200.00, 85, 45));
        custMap.put("C011", new Customer2("11", "Aiswarya", "India", 45, 8, 2800.00, 75, 35));
        custMap.put("C012", new Customer2("12", "Samantha", "India", 34, 5, 1900.00, 65, 28));
        custMap.put("C013", new Customer2("13", "Mammootty", "India", 65, 25, 5000.00, 98, 90));
        custMap.put("C014", new Customer2("14", "Jayaram", "India", 50, 15, 3800.00, 82, 60));
        custMap.put("C015", new Customer2("15", "Asif", "India", 29, 3, 1500.00, 55, 20));
        custMap.put("C016", new Customer2("16", "Kunjako", "India", 38, 7, 2200.00, 68, 32));
        custMap.put("C017", new Customer2("17", "Nayantara", "India", 39, 9, 3100.00, 78, 42));
        custMap.put("C018", new Customer2("18", "Vijay", "India", 42, 12, 4200.00, 88, 55));


        System.out.println("Customer Map Loaded:");

        //Task 2:
        //Create a program that takes a map of Customer objects as input and performs the following operations:
        //Filter out all customers who have joined in the last 3 years
        //and have a loyalty score less than 4, but have a balance between 2000 and 5000.
        Map<String, Customer2> refinedCustomerList = custMap.entrySet().stream()
                .filter(
                        entry -> !(entry.getValue().getYearsOfMembership() < 3 && entry.getValue().getLoyaltyScore() < 4)
                                && entry.getValue().getBalance() >= 2000
                                && entry.getValue().getBalance() <= 5000
                ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));


        //Calculate the sum of the balances of the remaining customers, but only for those who have an even age.
        double sumBalRemainingCustomers = refinedCustomerList.values().stream()
                .filter(
                        customer2 -> customer2.getAge() % 2 == 0
                )
                .mapToDouble(Customer2::getAge).sum();
        System.out.println("Sum of balances for customers with even age: " + sumBalRemainingCustomers);

        //Find the average age of the remaining customers, but only if their country has more than 10 customers.

        // First, counting customers by country in the original dataset
        Map<String, Long> countryCounts = custMap.values().stream()
                .collect(Collectors.groupingBy(Customer2::getCountry, Collectors.counting())); //Frequency of country
        countryCounts.forEach((country, count) ->
                System.out.println(country + ": " + count)
        );

        //calculating avg age if country has freq >10
        OptionalDouble averageAge = refinedCustomerList.values().stream()
                .filter(
                        customer ->
                                countryCounts.getOrDefault(customer.getCountry(), 0L) > 10L) //  calculating if the country is in countryCounts Freq list | if there checking freq>10
                .mapToInt(Customer2::getAge)
                .average();
        //printing such countries
        if (averageAge.isPresent()) {
            System.out.println("Average age of customers from countries with more than 10 customers: " + (int)averageAge.getAsDouble());
        } else {
            System.out.println("No customers found from countries with more than 10 customers");
        }

    }
}
