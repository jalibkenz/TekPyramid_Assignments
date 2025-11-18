package Assn_2025_11_17.Assn_2025_11_17_1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Employee2 {
    private long id;
    private String name;
    private String department;
    private String jobTitle;
    private int age;
    private int yearsOfExperience;
    private double salary;
    private int performanceRating;

    public Employee2(long id, String name, String department, String jobTitle, int age, int yearsOfExperience, double salary, int performanceRating) {
        this.id = id;
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
        return "Employee3{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", age=" + age +
                ", yearsOfExperience=" + yearsOfExperience +
                ", salary=" + salary +
                ", performanceRating=" + performanceRating +
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
}
public class Task2 {

    public static void main(String[] args) {
        System.out.println("Welcome");

        //creating 5 employee2s
        List<Employee2> employee2s = Arrays.asList(
                new Employee2(1,"Jalib Kenz", "IT", "Manager", 28, 3, 100001, 4),
                new Employee2(2,"Bob Thomas", "HR", "Manager", 35, 10, 68000, 5),
                new Employee2(3,"Chris Martin", "Finance", "Manager", 30, 6, 55000, 3),
                new Employee2(4,"Diana George", "IT", "Senior Developer", 32, 8, 90000, 5),
                new Employee2(5,"Nihal Khaiez", "Admin", "Office Assistant", 25, 2, 65000, 2)
        );

        List<Long> collect = employee2s.stream()
                .filter(employee2 ->
                        !(employee2.getYearsOfExperience() <= 5
                                && employee2.getPerformanceRating() < 8
                                && employee2.getSalary() >= 60000
                                && employee2.getSalary() <= 120000)
                )
                .sorted(Comparator.comparing(Employee2::getSalary).thenComparing(Employee2::getYearsOfExperience).reversed()
                )
                .map(employee2 -> employee2.getId() * 10L
                )
                .collect(Collectors.toList());
        System.out.println(collect);
    }
}

