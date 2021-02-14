/*
 * Copyright for LoggingQueueSemaphore.java by kumar since 12/10/20, 7:05 PM
 */

package semaphore;

import java.util.concurrent.Semaphore;

/**
 * @author kumar
 * @project java-8
 * @since 12-10-2020
 */
public class LoggingQueueSemaphore {
    private Semaphore semaphore;

    public LoggingQueueSemaphore (int permitsCount) {
        semaphore = new Semaphore(permitsCount);
    }
    boolean tryLogin () {
        return semaphore.tryAcquire();
    }

    void logOut() {
         semaphore.release();
    }

    int availablePermits () {
        return semaphore.availablePermits();
    }
    public static void main(String[] args) {
        LoggingQueueSemaphore queueSemaphore = new LoggingQueueSemaphore(5);
        System.out.println(queueSemaphore.tryLogin() ? "loggedIn" : "loggedOut");
        System.out.println(queueSemaphore.availablePermits());
        queueSemaphore.logOut();
        System.out.println("After logout remaining slots are: " + queueSemaphore.availablePermits());
    }
}
