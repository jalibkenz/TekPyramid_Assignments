package Assn_2025_11_17.Assn_2025_11_17_2;


//Task 1:
//Write a program that takes a set of Student objects as input and performs the following operations:
//Group the students by their major into a Map where the key is the major and the value is a set of students in that major,
//but only for majors with more than 5 students and an average GPA above 3.0.
//Sort the students within each major in ascending order of their GPA, and then by their age in descending order.
//Return the Map containing the grouped and sorted students.

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Student1 {
    private String name;
    private String major;
    private int age;
    private int yearsOfEnrollment;
    private double gpa;
    private int numberOfIncompleteCourses;

    public Student1(String name, String major, int age, int yearsOfEnrollment, double gpa, int numberOfIncompleteCourses) {
        this.name = name;
        this.major = major;
        this.age = age;
        this.yearsOfEnrollment = yearsOfEnrollment;
        this.gpa = gpa;
        this.numberOfIncompleteCourses = numberOfIncompleteCourses;
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
public class Task1 {
    public static void main(String[] args) {

        //creating list of students
        // Updated student list: Computer Science has 6 students (avg GPA > 3.0)
        Set<Student1> students = new HashSet<>();
        students.add(new Student1("Alice", "Computer Science", 20, 2, 3.8, 1));
        students.add(new Student1("Charlie", "Computer Science", 21, 1, 3.5, 0));
        students.add(new Student1("David", "Computer Science", 22, 3, 3.4, 0));
        students.add(new Student1("Fiona", "Computer Science", 19, 1, 3.2, 0));
        students.add(new Student1("George", "Computer Science", 23, 4, 3.1, 1));
        students.add(new Student1("Hanna", "Computer Science", 20, 2, 3.6, 0));

        // Other majors (will not meet >5 students)
        students.add(new Student1("Bob", "Mechanical Engineering", 22, 3, 3.2, 0));
        students.add(new Student1("Charlotte", "Business Administration", 19, 1, 3.9, 2));
        students.add(new Student1("Evelyn", "Psychology", 23, 4, 3.1, 3));
        students.add(new Student1("Ibrahim", "Electrical Engineering", 21, 2, 2.8, 1));
        students.add(new Student1("Jill", "Mathematics", 20, 2, 3.0, 0));



        //Group the students by their major into a Map where the key is the major and the value is a set of students in that major,
        //but only for majors with more than 5 students and an average GPA above 3.0.

        //Group students by major into Map<String, Set<Student1>>
        //but only for majors with more than 5 students and an average GPA above 3.0.
        Map<String, Set<Student1>> grouped = students.stream().collect(Collectors.groupingBy(Student1::getMajor, Collectors.toSet()));

        Map<String, Set<Student1>> map = grouped.entrySet().stream()
                .filter(entry -> entry.getValue().size() > 5) //set has size more than 5
                .filter(entry -> entry.getValue().stream()
                                                        .mapToDouble(Student1::getGpa)
                                                        .average().orElse(0) > 3.0
                )
                .collect(Collectors.toMap(
                        Map.Entry::getKey, Map.Entry::getValue
                ));


        //Sort the students within each major in ascending order of their GPA,
        // and then by their age in descending order.
        //Return the Map containing the grouped and sorted students.

        Map<String, Stream<Student1>> sortedMap = map.entrySet().stream()
                .collect(Collectors.toMap(

                                Map.Entry::getKey, //KEY MAPPER
                                entry->entry.getValue().stream() //VALUE MAPPER
                                        .sorted(Comparator.comparing(Student1::getGpa).thenComparing(
                                                        Comparator.comparing(Student1::getAge).reversed()
                                                )
                                        ),
                                (key1,key2)->key1, //MERGE FUNCTION
                                LinkedHashMap::new
                        )
                );

        //Printing
        sortedMap.forEach((major,studentSet)->{
            System.out.println("Major: "+major);
            studentSet.forEach(
                    student -> {
                        String nameFormatted15=String.format("%-15s",student.getName());
                        System.out.println("\t"+nameFormatted15+
                                            " | "+student.getGpa()+
                                            " | "+student.getAge()
                                );
            });
        });


    }


}
