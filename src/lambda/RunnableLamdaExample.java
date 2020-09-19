/*
 * Copyright for RunnableLamdaExample.java by kumar since 8/16/20, 12:42 AM
 */

package lambda;

/**
 * Created By Saurav Kumar on 7/5/2020
 */
public class RunnableLamdaExample {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        /**
         * prior java 8
         */
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Inside Runnable");
            }
        };

        new Thread(r).start();

        //java 8 lambda syntex
        Runnable runnable = () -> {
            System.out.println("Inside lamda Runnable-2");
        };
        new Thread(runnable).start();
        new Thread(() -> System.out.println("Runnable-3")).start();
    }
}
