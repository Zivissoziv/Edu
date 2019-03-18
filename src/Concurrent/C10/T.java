package Concurrent.C10;

import java.util.concurrent.TimeUnit;

/**
 * Created by Ziv on 2019/3/17.
 * synchronized优化方法
 * 1、synchronized包裹的代码尽量少点
 * 2、避免将锁定对象的引用变成另外对象
 * 3、不要以字符串常量作为锁定对象
 */
public class T {

    //优化一示例
    int count = 0;

    synchronized void m1(){
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count ++;
    }

    void m1_better(){
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (this){
            count++;
        }

    }

    //优化二示例
    Object o = new Object();
    void m2(){
        synchronized (o){
            while(true){
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            }
        }
    }

    public static void main(String[] args) {
        T t = new T();
        new Thread(()->t.m2(),"t1").start();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //创建第二个线程
        Thread t2 = new Thread(()->t.m2(), "t2");
        t.o = new Object();//锁对象发生改变，所以t2线程得以执行，如果注释掉这句话，线程2将永远得不到执行机会
        t2.start();
    }

    //优化三
    //在下面的例子中，m1和m2其实锁定的是同一个对象,有可能发生非常诡异的死锁阻塞
    String s1 = "Hello";
    String s2 = "Hello";
    void m3() {
        synchronized(s1) {

        }
    }

    void m4() {
        synchronized(s2) {

        }
    }
}
