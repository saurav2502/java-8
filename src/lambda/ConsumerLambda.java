/*
 * Copyright for ConsumerLambda.java by kumar since 8/16/20, 12:42 AM
 */

package lambda;

import data.Student;
import data.StudentDatabase;

import java.util.List;
import java.util.function.Consumer;

/**
 * Created By Saurav Kumar on 7/5/2020
 */
public class ConsumerLambda {
    /**
     * Print student name.
     */
    public static void printStudentName() {
        Consumer<Student> consumer = (student) -> System.out.println(student);
        List<Student> studentList = StudentDatabase.getAllStudents();
        studentList.forEach(consumer);
    }

    /**
     * Print name activities.
     */
    public static void printNameActivities() {
        List<Student> studentList = StudentDatabase.getAllStudents();
        Consumer<Student> con1 = (student) -> System.out.println(student.getName());
        Consumer<Student> con2 = (student) -> System.out.println(student.getActivities());
        Consumer<Student> con3 = (student) -> System.out.println(student.getGpa());
        studentList.forEach(data -> {
            if (data.getGradeLevel() >= 3) {
                con1.andThen(con2).andThen(con3).accept(data);
            }
        });
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        //printStudentName();
        printNameActivities();
    }
}
