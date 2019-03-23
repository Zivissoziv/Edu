package REAL;

import java.util.concurrent.TimeUnit;

/**
 * Created by Ziv on 2019/3/23.
 * 模拟一个死锁场景
 * t1锁了a，对b加锁
 * t2锁了b，对a加锁
 * 思考如何解锁
 */
public class Q12 {

    Object a = new Object();
    Object b = new Object();

    public static void main(String[] args) {
        Q12 q12 = new Q12();
        new Thread(() -> {
            synchronized (q12.a) {
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //解锁方法：q12.a释放锁
//                try {
//                    q12.a.wait();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                synchronized (q12.b) {
                    System.out.println("a");
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (q12.b) {
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (q12.a) {
                    System.out.println("b");
                    //用完之后通知所有线程锁已释放
//                    q12.a.notifyAll();
                }
            }
        }).start();
    }

}
