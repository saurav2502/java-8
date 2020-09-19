/*
 * Copyright for PredicateLambda.java by kumar since 8/16/20, 12:42 AM
 */

package lambda;

import data.Student;
import data.StudentDatabase;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created By Saurav Kumar on 7/5/2020
 */
public class PredicateLambda {

    /**
     * The P 1.
     */
    static Predicate<Integer> p1 = (i) -> i % 2 == 0;
    /**
     * The P 2.
     */
    static Predicate<Integer> p2 = (i) -> i % 5 == 0;
    /**
     * The P 3.
     */
    static Predicate<Integer> p3 = (i) -> i % 10 == 0;

    /**
     * The P 4.
     */
    static Predicate<Student> p4 = (s) -> s.getGradeLevel()>=3;

    /**
     * The P 5.
     */
    static Predicate<Student> p5 = (s) -> s.getGpa()>=3.9;

    /**
     * The Grade predicate.
     */
    static Function<Integer,Predicate<Integer>> gradePredicate = (toCompare) -> (number) -> number > toCompare;
    /**
     * The Gpa predicate.
     */
    static Function<Double,Predicate<Double>>  gpaPredicate = (toCompare) -> (number) -> number > toCompare;


    /**
     * Predicate or.
     */
    public static void predicateOr() {
        System.out.println(p1.and(p2).test(10));
    }

    /**
     * Predicate and.
     */
    public static void predicateAnd() {
        System.out.println( p1.and(p3).test(10));
    }

    /**
     * Predicate negate.
     */
    public static void predicateNegate() {
        System.out.println(p1.or(p3).negate().test(15));
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        predicateAnd();
        predicateNegate();
        predicateOr();

        List<Student> studentList = StudentDatabase.getAllStudents();
        studentList.forEach((student -> {
            if(p4.test(student)){
                System.out.println(student);
            }
        }));

        boolean result = gradePredicate.apply(2).test(5) && gpaPredicate.apply(3.6).test(3.9);
        System.out.println("Result from Predicate : " + result);
    }
}
