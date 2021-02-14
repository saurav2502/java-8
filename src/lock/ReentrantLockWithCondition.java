/*
 * Copyright for ReentrantLockWithCondition.java by kumar since 12/10/20, 7:59 PM
 */

package lock;

import java.util.Stack;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author kumar
 * @project java-8
 * @since 12-10-2020
 */
public class ReentrantLockWithCondition{
    Stack<String> stack = new Stack<>();
    int CAPACITY = 5;

    ReentrantLock lock = new ReentrantLock();
    Condition stackEmptyCondition = lock.newCondition();
    Condition stackFullCondition = lock.newCondition();

    public void pushToStack(String item) throws InterruptedException {
        try {
            lock.lock();
            while(stack.size() == CAPACITY) {
                stackFullCondition.await();
            }
            stack.push(item);
            System.out.println("pushing item: "+ item);
            stackEmptyCondition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public String popFromStack() throws InterruptedException {
        try {
            lock.lock();
            while(stack.size() == 0) {
                stackEmptyCondition.await();
            }
            String item = stack.pop();
            System.out.println("popping item: "+ item);
            return item;
        } finally {
            stackFullCondition.signalAll();
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantLockWithCondition lockWithCondition = new ReentrantLockWithCondition();
        Runnable thread1 = new Runnable(){
            @Override
            public void run() {
                for (int i = 1; i <= 5 ; i++) {
                    try {
                        lockWithCondition.pushToStack(String.valueOf(i));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Runnable thread2 = new Runnable(){
            @Override
            public void run() {
                for (int i = 1; i <= 5 ; i++) {
                    try {
                        lockWithCondition.popFromStack();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        thread1.run();
        thread2.run();
    }
}
