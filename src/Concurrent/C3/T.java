package Concurrent.C3;

/**
 * Created by Ziv on 2019/3/17.
 * 同步和非同步方法是否可以同时调用？
 * 可以
 */
public class T {
    synchronized void m1() {
        System.out.println("m1 start!");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m1 end!");
    }

    void m2() {
        System.out.println("m2 start!");
    }

    public static void main(String[] args) {
        T t = new T();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                t.m1();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                t.m2();
            }
        });
        t1.start();
        t2.start();
    }

}
