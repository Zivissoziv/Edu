package Concurrent.C12;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Ziv on 2019/3/17.
 * reentrantlock可以用于替代synchronized
 * 但是reentrantlock要手动锁定和释放锁(一定要在finally中加上unlock)
 */
public class ReentrantLock1 {

    ReentrantLock lock = new ReentrantLock();

    void m1() {
        lock.lock();
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("线程1:" + i);
                TimeUnit.SECONDS.sleep(1);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    void m2() {
        lock.lock();
        System.out.println("线程2启动");
        lock.unlock();
    }

    public static void main(String[] args) {
        ReentrantLock1 t = new ReentrantLock1();
        new Thread(new Runnable() {
            @Override
            public void run() {
                t.m1();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                t.m2();
            }
        }).start();
    }

}
