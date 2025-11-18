package Assn_2025_11_17.Assn_2025_11_17_2;


//Task 3:
//Create a program that takes a set of Student objects as input and performs the following operations:
//Filter out all students who have joined in the last 3 years and have a major in Mathematics, but have a GPA below 3.0 and are on academic probation.
//Calculate the sum of the GPAs of the remaining students, but only for those who have an age above 22 and a GPA above the average GPA.
//Find the average age of the remaining students, but only if their department has more than 10 students and an average GPA above 3.5.
//Calculate the factorial of the average age, but only if the total years of enrollment of all students is greater than 30 and the average GPA is below 3.9.

import java.math.BigInteger;
import java.time.Year;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Student3 {
    private String name;
    private int age;
    private String major;
    private double gpa;
    private int numberOfIncompleteCourses;
    private int yearsOfEnrollment;
    private boolean onProbation;

    public Student3(String name, int age, String major, double gpa, int numberOfIncompleteCourses, int yearsOfEnrollment, boolean onProbation) {
        this.name = name;
        this.major = major;
        this.age = age;
        this.yearsOfEnrollment = yearsOfEnrollment;
        this.gpa = gpa;
        this.numberOfIncompleteCourses = numberOfIncompleteCourses;
        this.onProbation = onProbation;
    }

    @Override
    public String toString() {
        return "Student3{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", major='" + major + '\'' +
                ", gpa=" + gpa +
                ", numberOfIncompleteCourses=" + numberOfIncompleteCourses +
                ", yearsOfEnrollment=" + yearsOfEnrollment +
                ", onProbation=" + onProbation +
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

    public boolean isOnProbation() {
        return onProbation;
    }

    public void setOnProbation(boolean onProbation) {
        this.onProbation = onProbation;
    }
}

public class Task3 {
    public static void main(String[] args) {

        //creating set of students
        Set<Student3> students = Set.of(
                // 15 Computer Science students (ages >22 and high GPAs)
                new Student3("CS_01", 23, "Computer Science", 3.8, 0, 2021, false),
                new Student3("CS_02", 24, "Computer Science", 3.7, 0, 2021, false),
                new Student3("CS_03", 25, "Computer Science", 3.9, 0, 2020, false),
                new Student3("CS_04", 26, "Computer Science", 3.6, 0, 2020, false),
                new Student3("CS_05", 27, "Computer Science", 3.75, 0, 2019, false),
                new Student3("CS_06", 28, "Computer Science", 3.65, 0, 2019, false),
                new Student3("CS_07", 29, "Computer Science", 3.7, 0, 2018, false),
                new Student3("CS_08", 30, "Computer Science", 3.85, 0, 2018, false),
                new Student3("CS_09", 24, "Computer Science", 3.6, 0, 2021, false),
                new Student3("CS_10", 25, "Computer Science", 3.7, 0, 2022, false),
                new Student3("CS_11", 26, "Computer Science", 3.8, 0, 2021, false),
                new Student3("CS_12", 27, "Computer Science", 3.6, 0, 2019, false),
                new Student3("CS_13", 28, "Computer Science", 3.75, 0, 2019, false),
                new Student3("CS_14", 29, "Computer Science", 3.9, 0, 2018, false),
                new Student3("CS_15", 31, "Computer Science", 3.85, 0, 2017, false),

                // 2 Mathematics (one low-GPA & on probation will be removed by rule#1)
                new Student3("M_Hank", 26, "Mathematics", 3.85, 1, 2024, true),
                new Student3("M_Jack", 23, "Mathematics", 2.50, 2, 2024, true),

                // 3 other low-GPA students (to keep overall avg lower)
                new Student3("Bio_A", 19, "Biology", 2.9, 1, 2024, false),
                new Student3("Chem_B", 20, "Chemistry", 2.7, 1, 2023, false),
                new Student3("Eng_D", 28, "Engineering", 3.0, 0, 2015, false)
        );


        //Create a program that takes a set of Student objects as input and performs the following operations:
        //Filter out all students who have joined in the last 3 years and have a major in Mathematics, but have a GPA below 3.0 and are on academic probation.
        int currentYear = Year.now().getValue();
        Set<Student3> mathsStudents = students.stream()
                .filter(student3 ->
                        currentYear - student3.getYearsOfEnrollment() <= 3
                                && student3.getMajor().equals("Mathematics")
                                && student3.getGpa() < 3.0
                                && student3.isOnProbation()
                ).collect(Collectors.toSet());

        mathsStudents.forEach(System.out::println);

        //Calculate the sum of the GPAs of the remaining students, but only for those who have an age above 22 and a GPA above the average GPA.

        double avgGPA = students.stream().mapToDouble(Student3::getGpa).average().orElse(0.0);
        System.out.println("Average GPA: " + avgGPA);

        Set<Student3> remainingStudents = students.stream()
                .filter(
                        student3 -> !mathsStudents.contains(student3)
                )
                .filter(student3 -> student3.getAge() > 22 && student3.getGpa() > avgGPA).collect(Collectors.toSet());
        //Find the average age of the remaining students, but only if their department has more than 10 students and an average GPA above 3.5.


        Set<Map.Entry<String, List<Student3>>> mapRemStd = remainingStudents.stream() //creating map of major and its students from the remaining list of students
                .collect(Collectors.groupingBy(Student3::getMajor))
                .entrySet().stream()
                .filter(entry ->
                        entry.getValue().size() > 10
                                && entry.getValue().stream().mapToDouble(Student3::getGpa).average().orElse(0) > 3.5
                ).collect(Collectors.toSet());

        double avgAgeRemStd =
                remainingStudents.stream()
                        .collect(Collectors.groupingBy(Student3::getMajor))
                        .values().stream()                                // Stream<List<Student3>>
                        .filter(list ->
                                list.size() > 10 &&
                                        list.stream().mapToDouble(Student3::getGpa).average().orElse(0.0) > 3.5
                        )
                        .mapToDouble(list ->
                                list.stream().mapToInt(Student3::getAge).average().orElse(0.0)
                        )
                        .findFirst()
                        .orElse(0.0);   // average age for first qualifying department

        System.out.println("Remaining Students Average Age: " + avgAgeRemStd);


        //Calculate the factorial of the average age,
        //but only if the total years of enrollment of all students is greater than 30
        //and the average GPA is below 3.9.
        int remStdTotalYearsOfEnrollment = remainingStudents.stream().mapToInt(student->currentYear-student.getYearsOfEnrollment()).sum();
        System.out.println("Remaining Student's Total Year of Enrollment: "+remStdTotalYearsOfEnrollment);
        double avgGpaRemStd = remainingStudents.stream().mapToDouble(Student3::getGpa).average().orElse(0.0);
        System.out.println("Remaining Student's Average GPA: "+avgGpaRemStd);
        if(remStdTotalYearsOfEnrollment>30 && avgGpaRemStd<3.9){
            System.out.println("Factorial "+"of "+(int)avgAgeRemStd+" is: "+factorial((int)avgAgeRemStd));
        }
    }

    public static BigInteger factorial(int n) {
        BigInteger result = BigInteger.ONE;

        for (int i = 1; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }

        return result;
    }



}