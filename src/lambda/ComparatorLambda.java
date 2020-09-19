/*
 * Copyright for ComparatorLambda.java by kumar since 8/16/20, 12:42 AM
 */

package lambda;

import java.util.Comparator;

/**
 * Created By Saurav Kumar on 7/5/2020
 */
public class ComparatorLambda {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };
        System.out.println("Result of comparator is = " + comparator.compare(3,4));

        // prior java-8
        Comparator<Integer> com = (o1, o2) -> o1.compareTo(o2);
        System.out.println(com.compare(4,3));
    }
}
