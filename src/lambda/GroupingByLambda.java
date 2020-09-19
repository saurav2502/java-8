/*
 * Copyright for GroupingByLambda.java by kumar since 8/16/20, 12:42 AM
 */

package lambda;

import data.Student;
import data.StudentDatabase;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;

import static java.util.stream.Collectors.*;

/**
 * The type Grouping by lambda.
 *
 * @author Saurav Kumar
 * @project java -8
 * @since 7 /11/2020
 */
public class GroupingByLambda
{
    /**
     * The P 1.
     */
    public static Predicate<Student> p1 = (data) -> data.getGpa() > 3.5;

    /**
     * The C 1.
     */
    public static Consumer<Student> c1 = (student) -> System.out.println(student.toString());

    /**
     * The B 1.
     */
    public static BiConsumer<Double, List<Student>> b1 =
        ((aDouble, students) -> System.out.println(aDouble + " " + students));

    /**
     * Sort students.
     */
    public static void sortStudents()
    {
        List<Student> studentList = StudentDatabase.getAllStudents();
        /*
         * Map<Integer, Optional<Student>> op= studentList .stream() .collect(groupingBy(Student::getGradeLevel,
         * maxBy(Comparator.comparing(Student::getGpa))));
         */

        Map<Integer, Student> op = studentList.stream().collect(groupingBy(Student::getGradeLevel,
            collectingAndThen(maxBy(Comparator.comparing(Student::getGpa)), Optional::get)));

        System.out.println(op);

        /*
         * studentList .stream() .filter(p1) .collect(groupingBy(Student::getGpa)) .forEach(b1);
         */

        /*
         * studentList .stream() .filter(p1) .distinct() .collect(Collectors.toList()) .forEach(c1);
         */

    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args)
    {
        sortStudents();
    }
}
