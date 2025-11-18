package Assn_2025_11_17;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class Employee3 {
    private long id;
    private String name;
    private String department;
    private String jobTitle;
    private int age;
    private int yearsOfExperience;
    private double salary;
    private int performanceRating;
    private String employmentType;

    public Employee3(long id, String name, String department, String jobTitle, int age, int yearsOfExperience, double salary, int performanceRating, String employmentType) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.jobTitle = jobTitle;
        this.age = age;
        this.yearsOfExperience = yearsOfExperience;
        this.salary = salary;
        this.performanceRating = performanceRating;
        this.employmentType = employmentType;
    }

    @Override
    public String toString() {
        return "Employee3{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", age=" + age +
                ", yearsOfExperience=" + yearsOfExperience +
                ", salary=" + salary +
                ", performanceRating=" + performanceRating +
                ", employmentType='" + employmentType + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getEmploymentType() {
        return employmentType;
    }

    public void setEmploymentType(String employmentType) {
        this.employmentType = employmentType;
    }
}

public class Task3 {

    public static void main(String[] args) {
        System.out.println("Welcome");

        //creating 5 employee3s
        List<Employee3> employee3s = Arrays.asList(
                new Employee3(1, "Jalib Kenz", "IT", "Manager", 28, 3, 100001, 7,"FullTime"),
                new Employee3(2, "Bob Thomas", "HR", "Manager", 35, 10, 68000, 5,"FullTime"),
                new Employee3(3, "Chris Martin", "Finance", "Manager", 30, 6, 55000, 3,"FullTime"),
                new Employee3(4, "Diana George", "Sales", "Senior Developer", 32, 8, 90000, 5,"FullTime"),
                new Employee3(5, "Nihal Khaiez", "Marketing", "Office Assistant", 25, 2, 65000, 2,"PartTime")
        );


        //collecting the filtered list
        List<Employee3> collect = employee3s.stream()
                .filter(
                        employee3 -> !(
                                employee3.getEmploymentType().equals("PartTime")
                                        && employee3.getSalary() < 50000
                                        && (employee3.getDepartment().equals("Sales") || employee3.getDepartment().equals("Marketing"))
                        )
                ).collect(Collectors.toList());


        //Calculate the sum of the salaries of the remaining employees, but only for those who have more than 3 years of experience.
        double sumSalaries = collect.stream()
                .filter(
                        employee3 -> employee3.getYearsOfExperience() > 3
                )
                .mapToDouble(
                        employee3 -> employee3.getSalary()
                ).sum();
        System.out.println("Sum of Salaries "+sumSalaries);

        //Find the average age of the remaining employees, but only for those who have a performance rating of at least 7.
        int avgAge = (int) collect.stream()
                .filter(employee3 -> employee3.getPerformanceRating() >= 7
                )
                .mapToInt(employee3 -> employee3.getAge()
                ).average().orElse(0);
        System.out.println("Avg Age "+avgAge);

    }
}

