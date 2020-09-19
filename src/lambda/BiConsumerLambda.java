/*
 * Copyright for BiConsumerLambda.java by kumar since 8/16/20, 12:42 AM
 */

package lambda;

import data.Student;
import data.StudentDatabase;

import java.util.List;
import java.util.function.BiConsumer;

/**
 * Created By Saurav Kumar on 7/5/2020
 */
public class BiConsumerLambda {

    /**
     * Print name.
     */
    public static void printName() {
        BiConsumer<String, List<String>>con1 = (a,b) -> System.out.println(a +" : " + b);
        BiConsumer<String, List<String>>con2 = (a,b) -> System.out.println(a +" : " + b);
        List<Student> stu = StudentDatabase.getAllStudents();
        stu.forEach(students -> {
            if (students.getGradeLevel() >= 3) {
                con1.andThen(con2).accept(students.getName(),students.getActivities());
            }
        });
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        printName();
    }
}
