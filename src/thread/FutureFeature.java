/*
 * Copyright for FutureFeature.java by kumar since 9/16/20, 12:25 PM
 */

package thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;

/**
 * @author kumar
 * @project java-8
 * @since 9/16/2020
 */
public class FutureFeature {
    public static void process(CompletableFuture<Integer> future) {
        future.thenApply(data -> data * 2)
                .exceptionally(throwable -> handle(throwable))
                .thenApply(data -> data + 1)
                .thenAccept(data -> {
                    System.out.println(data);
                });
    }

    private static Integer handle(Throwable throwable) {
        System.out.println("some thing went wrong");
        return 100;
    }

    public static void main(String[] args) throws InterruptedException {
        /*CompletableFuture<Integer> cf = new CompletableFuture<>();
        process(cf);
        Supplier<Integer> supplier = new Supplier<>() {

            @Override
            public Integer get() {
                return 20;
            }
        };*/
        //cf.complete(2);
        //cf.completeExceptionally(new RuntimeException("some thing wrong"));
        //System.out.println(cf.completeAsync(supplier));
        /*create(2).thenCompose(data -> create(data))
        .thenAccept(System.out::println);*/
        RunnableFuture runnableFuture = new FutureTask<Boolean>(() -> {System.out.println("inside call");
            return false;
        });
        new Thread(runnableFuture).start();
        try {
            System.out.println("future result " + runnableFuture.get());
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    private static CompletableFuture<Integer> create(int data) {
        return CompletableFuture.supplyAsync(() -> data);
    }




}
