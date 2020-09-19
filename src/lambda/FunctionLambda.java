/*
 * Copyright for FunctionLambda.java by kumar since 8/16/20, 12:42 AM
 */

package lambda;

import java.util.function.Function;

/**
 * Created By Saurav Kumar on 7/5/2020
 */
public class FunctionLambda {

    /**
     * The Upper case.
     */
    static Function<String,String> upperCase =  (name) -> name.toUpperCase();

    /**
     * The Add some string.
     */
    static Function<String,String> addSomeString =  (name) -> name.toUpperCase().concat("default");

    /**
     * The Str length.
     */
    static Function<String,Integer> strLength =  (name) -> name.length();

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        System.out.println(upperCase.apply("java-8"));

        /**
         * andThen Method first call uppercase predicate and output of predicate uppercase will
         * be "JAVA-8", treated as input for predicate addsomething to return "JAVA-8default"
         */
        System.out.println(upperCase.andThen(addSomeString).apply("java-8"));

        /**
         * default compose method will first call addsomething predicate to return JAVA-8default,
         * And Then it will pass output of predicate "addsomething" to predicate "uppercase"
         * To reutrn output as "JAVA-8DEFAULT"
         */
        System.out.println(upperCase.compose(addSomeString).apply("java-8"));

        Function<String,String> abc = Function.identity();
        System.out.println(abc.apply("ABC"));
    }
}
