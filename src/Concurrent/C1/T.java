package Concurrent.C1;

/**
 * Created by Ziv on 2019/3/17.
 * synchronized关键字
 * 对某个对象加锁的几种方式
 */
public class T {
    private static int count = 10;
    private Object o = new Object();


    public void m() {
        synchronized (o) {//给对象o加锁
            count--;
            System.out.println(Thread.currentThread().getName() + "count =" + count);
        }
    }

    public void n() {
        synchronized(this){//给对象T加锁
            count--;
            System.out.println(Thread.currentThread().getName() + "count =" + count);
        }
    }

    public synchronized void o(){//等同于上面
        count--;
        System.out.println(Thread.currentThread().getName() + "count =" + count);
    }

    public synchronized static void p() { //有static等同于synchronized(T.class)
        count--;
        System.out.println(Thread.currentThread().getName() + " count = " + count);
    }
}
