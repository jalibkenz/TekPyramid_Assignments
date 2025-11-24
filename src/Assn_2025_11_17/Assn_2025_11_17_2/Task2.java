package Assn_2025_11_17.Assn_2025_11_17_2;
//Task 2:
//Implement a program that reads a set of Student objects from the user and performs the following operations:
//Filter out all students who have a GPA less than the average GPA of all students, but have an age above 18 and a major in Biology or Chemistry.
//Calculate the total years of enrollment of the remaining students, but only for those who have joined in the last 4 years and are majoring in Computer Science or Engineering.
//Find the student with the highest years of enrollment and return their details, but only if they have an age below 30 and a GPA above 3.7.

import java.time.Year;
import java.util.*;
import java.util.stream.Collectors;

class Student2 {
    private String name;
    private String major;
    private int age;
    private int yearsOfEnrollment;
    private double gpa;
    private int numberOfIncompleteCourses;

    public Student2(String name, int age, String major, double gpa, int numberOfIncompleteCourses, int yearsOfEnrollment) {
        this.name = name;
        this.major = major;
        this.age = age;
        this.yearsOfEnrollment = yearsOfEnrollment;
        this.gpa = gpa;
        this.numberOfIncompleteCourses = numberOfIncompleteCourses;
    }

    @Override
    public String toString() {
        return "Student2{" +
                "name='" + name + '\'' +
                ", major='" + major + '\'' +
                ", age=" + age +
                ", yearsOfEnrollment=" + yearsOfEnrollment +
                ", gpa=" + gpa +
                ", numberOfIncompleteCourses=" + numberOfIncompleteCourses +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getYearsOfEnrollment() {
        return yearsOfEnrollment;
    }

    public void setYearsOfEnrollment(int yearsOfEnrollment) {
        this.yearsOfEnrollment = yearsOfEnrollment;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public int getNumberOfIncompleteCourses() {
        return numberOfIncompleteCourses;
    }

    public void setNumberOfIncompleteCourses(int numberOfIncompleteCourses) {
        this.numberOfIncompleteCourses = numberOfIncompleteCourses;
    }
}

public class Task2 {
    public static void main(String[] args) {

        //creating set of students
        Set<Student2> students = Set.of(
                new Student2("Alice", 19, "Biology", 3.00, 2, 2024),
                new Student2("Bob", 20, "Chemistry", 2.80, 3, 2023),
                new Student2("Carol", 22, "Computer Science", 3.60, 4, 2022),
                new Student2("Dave", 28, "Engineering", 3.90, 6, 2019),
                new Student2("Eve", 17, "Biology", 3.20, 1, 2025),
                new Student2("Frank", 24, "Computer Science", 3.80, 3, 2022),
                new Student2("Grace", 30, "Engineering", 3.75, 5, 2020),
                new Student2("Hank", 26, "Mathematics", 3.85, 2, 2024),
                new Student2("Ivy", 21, "Chemistry", 3.55, 2, 2023),
                new Student2("Jack", 23, "Computer Science", 3.20, 2, 2024)
        );

        //Filter out all students who have a GPA less than the average GPA of all students,
        // but have an age above 18 and a major in Biology or Chemistry.

        //average GPA of all students
        double avgGPA=students.stream().mapToDouble(Student2::getGpa).average().orElse(0.0);
        System.out.println("Average GPA of all students "+avgGPA);

        Set<Student2> filteredSet = students.stream().filter(
                student2 -> !(student2.getGpa() < avgGPA)
                        && student2.getAge() > 18
                        && (student2.getMajor().equals("Biology") || student2.getMajor().equals("Chemistry"))
        ).collect(Collectors.toSet());

        //Calculate the total years of enrollment of the remaining students,
        //but only for those who have joined in the last 4 years and are majoring in Computer Science or Engineering.
        int currentYear = Year.now().getValue();
        int totalYearsOfEnrollment = filteredSet.stream()
                .filter(student2 -> student2.getYearsOfEnrollment() >= (currentYear - 4)
                        && (student2.getMajor().equals("Computer Science") || student2.getMajor().equals("Engineering")))
                .mapToInt(student2 -> student2.getYearsOfEnrollment() - currentYear)
                .sum();

        System.out.println("Total Year of Enrollment"+totalYearsOfEnrollment);


        //Find the student with the highest years of enrollment and return their details,
        // but only if they have an age below 30 and a GPA above 3.7.
        Student2 first = students.stream()
                .filter(student2 -> student2.getAge() < 30 && student2.getGpa() > 3.7)
                .sorted(Comparator.comparing(Student2::getYearsOfEnrollment))
                .toList().getFirst();
        System.out.println(first);


    }
}