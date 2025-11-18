package Assn_2025_11_17.Assn_2025_11_17_1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Employee {
    private String name;
    private String department;
    private String jobTitle;
    private int age;
    private int yearsOfExperience;
    private double salary;
    private int performanceRating;

    public Employee(String name, String department, String jobTitle, int age, int yearsOfExperience, double salary, int performanceRating) {
        this.name = name;
        this.department = department;
        this.jobTitle = jobTitle;
        this.age = age;
        this.yearsOfExperience = yearsOfExperience;
        this.salary = salary;
        this.performanceRating = performanceRating;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", age=" + age +
                ", yearsOfExperience=" + yearsOfExperience +
                ", salary=" + salary +
                ", performanceRating=" + performanceRating +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getPerformanceRating() {
        return performanceRating;
    }

    public void setPerformanceRating(int performanceRating) {
        this.performanceRating = performanceRating;
    }
}
public class Task1 {

    public static void main(String[] args) {
        System.out.println("Welcome");

        //creating 5 employees
        List<Employee> employees = Arrays.asList(
                new Employee("Jalib Kenz", "IT", "Manager", 28, 3, 100001, 4),
                new Employee("Bob Thomas", "HR", "Manager", 35, 10, 68000, 5),
                new Employee("Chris Martin", "Finance", "Manager", 30, 6, 55000, 3),
                new Employee("Diana George", "IT", "Senior Developer", 32, 8, 90000, 5),
                new Employee("Evan Wilson", "Admin", "Office Assistant", 25, 2, 30000, 2)
        );

        List<String> manager = employees.stream()
                .filter(employee -> !(
                                employee.getJobTitle().equals("Manager")
                                        && employee.getSalary() > 100000
                                        && employee.getYearsOfExperience() <= 3
                        )
                )
                .sorted(
                        Comparator.comparing(Employee::getYearsOfExperience).reversed()
                                .thenComparing(Employee::getPerformanceRating)
                )
                .map(
                        employee -> new StringBuilder(employee.getName()).reverse().toString().toUpperCase()
                ).collect(Collectors.toList());

        System.out.println(manager);

    }
}
