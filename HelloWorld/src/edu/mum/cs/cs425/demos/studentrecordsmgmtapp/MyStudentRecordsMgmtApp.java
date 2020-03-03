package edu.mum.cs.cs425.demos.studentrecordsmgmtapp;

import edu.mum.cs.cs425.demos.studentrecordsmgmtapp.model.Student;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyStudentRecordsMgmtApp {

    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

        Student s1 = new Student("110001", "Dave", sdf.parse("11/18/1951"));
        Student s2 = new Student("110002", "Anna", sdf.parse("12/07/1990"));
        Student s3 = new Student("110003", "Erica", sdf.parse("01/31/1974"));
        Student s4 = new Student("110004", "Carlos", sdf.parse("08/22/2009"));
        Student s5 = new Student("110005", "Bob", sdf.parse("03/05/1990"));

        Student[] arrayOfStudent = {s1 , s2 , s3 , s4 , s5};

        System.out.println(System.lineSeparator() +"------ Print All Students ------");
        printListOfStudents(arrayOfStudent);

        System.out.println(System.lineSeparator() +"------ Print All PlatinumAlumni Students ------");
        getListOfPlatinumAlumniStudents(arrayOfStudent).forEach(s -> System.out.println(s));

        System.out.println(System.lineSeparator() +"------ Print Hello World ------");
        Integer[] arrayInt = {1,2,3,4,5,19,9,11,0,12};
        printHelloWorld(arrayInt);

        System.out.println(System.lineSeparator() +"------ Print Second Bigest ------");
        System.out.println(findSecondBiggest(arrayInt));

    }

    public static void printListOfStudents(Student[] students) {
        Stream.of(students).forEach(student -> System.out.println(student));
    }

    public static List<Student> getListOfPlatinumAlumniStudents(Student[] students){
        Calendar backTo30Years = Calendar.getInstance();
        backTo30Years.roll(Calendar.YEAR , -30);

        return Stream.of(students)
                .filter(student -> student.getDateOfAdmission().compareTo(backTo30Years.getTime()) <= 0)
                .sorted((s1, s2) -> s2.getDateOfAdmission().compareTo(s1.getDateOfAdmission()))
                .collect(Collectors.toList());

    }

    public static void printHelloWorld(Integer[] numbers){
        Stream.of(numbers).forEach(ints -> {
            if((ints % 5 == 0) && (ints % 7 == 0)) System.out.println("HelloWorld");
            else if(ints % 5 == 0) System.out.println("Hello");
            else if(ints % 7 == 0) System.out.println("World");
        });
    }

    public static Integer findSecondBiggest(Integer[] numbers){
        int max = numbers[0];
        int max2 = numbers[0];

        for(Integer ints : numbers) {
            if(ints > max) {
                max2 = max;
                max = ints;
            }else if(ints > max2) max2 = ints;
        }

        return max2;
    }

}
