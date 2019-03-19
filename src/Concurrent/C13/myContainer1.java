package Concurrent.C13;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

/**
 * Created by Ziv on 2019/3/18.
 * 面试题：写一个固定容量同步容器，拥有put和get方法，以及getCount方法，
 * 能够支持2个生产者线程以及10个消费者线程的阻塞调用
 *
 * 使用wait和notify/notifyAll来实现
 */
public class myContainer1<T> {
    LinkedList<T> conatiner = new LinkedList<>();
    final private int MAX = 10;
    int count = 0;

    //wait绝大多数情况下都要跟着while使用
    //如果用if，假设两个p在等待生产，c消费完后wait释放锁，两个p同时醒来会出现异常
    synchronized void put(T t) {
        while (conatiner.size() == MAX) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        ++count;
        conatiner.add(t);
        //能用notifyAll就不要用notify
        //如果使用notify，假设一个p生产完后释放锁通知到的是另一个阻塞中的p线程而不是c线程，就会进入死锁状态
        this.notifyAll();
    }

    synchronized T get() {
        while (conatiner.isEmpty()) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        T t = conatiner.removeFirst();
        --count;
        this.notifyAll();
        return t;
    }

    synchronized int getCount() {
        return count;
    }

    //以下进行测试
    public static void main(String[] args) {
        myContainer1<String> c = new myContainer1<>();


        //启动10个消费者进程,每个进程消费5次
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 5; j++) System.out.println(Thread.currentThread().getName() + " " + c.get());
            }, "c" + i).start();
        }
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        //启动2个生产者进程，一共生产20个数据
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                for (int j = 0; j < 10; j++) c.put(Thread.currentThread().getName() + " " + j);
            }, "p" + i).start();
        }
    }
}
