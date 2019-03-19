package Concurrent.C12;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Ziv on 2019/3/17.
 * ReentrantLock
 * 使用ReentrantLock还可以调用lockInterruptibly方法，可以对线程interrupt方法做出响应，
 * 在一个线程等待锁的过程中，可以被打断
 */
public class ReentrantLock3 {

    ReentrantLock lock = new ReentrantLock();

    void m1() {
        lock.lock();
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("t1:" + i);
                TimeUnit.SECONDS.sleep(1);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    void m2() {
        try {
            lock.lockInterruptibly();
            System.out.println("t2 start");
            TimeUnit.SECONDS.sleep(5);
            System.out.println("t2 end");
        } catch (InterruptedException e) {
            System.out.println("interrupted!");
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantLock3 r3 = new ReentrantLock3();
        new Thread(() -> r3.m1()).start();
        Thread t2 = new Thread(() -> r3.m2());
        t2.start();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.interrupt();
    }

}
