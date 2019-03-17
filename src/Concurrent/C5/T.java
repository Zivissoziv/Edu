package Concurrent.C5;

import java.util.concurrent.TimeUnit;

/**
 * Created by Ziv on 2019/3/17.
 * 一个同步方法是否可以调用另外一个同步方法?
 * 一个线程已经拥有某个对象的锁，再次申请的时候能否得到该对象的锁？
 * 以上情况是否适用于继承？
 * synchronized锁的重用
 */
public class T {
    synchronized void m1() {
        System.out.println("m1 start");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        m2();
    }

    synchronized void m2() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m2 start");
    }

    public static void main(String[] args) {
//        T t = new T();
//        new Thread(()->t.m1()).start();

        //实验2
        TT tt = new TT();
        new Thread((()->tt.m1())).start();
    }
}

class TT extends T{
    @Override
    synchronized void m1() {
        System.out.println("child m1 start");
        super.m1();
        System.out.println("child m1 end");
    }
}
