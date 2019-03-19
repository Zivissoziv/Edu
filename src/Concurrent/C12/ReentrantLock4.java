package Concurrent.C12;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Ziv on 2019/3/18.
 * ReentrantLock是公平锁
 * 相比于synchronized释放锁后随机发放给等待线程,
 * ReentrantLock在释放锁后会先发放给那些等待时间较长的线程
 */
public class ReentrantLock4 implements Runnable{
    private static ReentrantLock lock=new ReentrantLock(true); //参数为true表示为公平锁，请对比输出结果
    public void run() {
        for(int i=0; i<100; i++) {
            lock.lock();
            try{
                System.out.println(Thread.currentThread().getName()+"获得锁");
            }finally{
                lock.unlock();
            }
        }
    }
    public static void main(String[] args) {
        ReentrantLock4 rl=new ReentrantLock4();
        Thread th1=new Thread(rl);
        Thread th2=new Thread(rl);
        th1.start();
        th2.start();
    }
}
