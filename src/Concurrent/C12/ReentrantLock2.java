package Concurrent.C12;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Ziv on 2019/3/17.
 * ReentrantLock的tryLock方法可以在等待无锁后执行其他操作
 */
public class ReentrantLock2 {

    ReentrantLock lock = new ReentrantLock();

    void m1() {
        lock.lock();
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("线程一:" + i);
                TimeUnit.SECONDS.sleep(1);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    void m2() {
        boolean b = false;
        try {
            b = lock.tryLock(5, TimeUnit.SECONDS);
            if (b) {
                System.out.println("线程二等待成功，执行A");
            } else {
                System.out.println("线程二放弃等待，执行B");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if(b) lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantLock2 r2 = new ReentrantLock2();
        new Thread(()->r2.m1()).start();
        new Thread(()->r2.m2()).start();
    }


}
