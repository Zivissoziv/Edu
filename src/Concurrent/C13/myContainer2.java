package Concurrent.C13;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Ziv on 2019/3/18.
 * 面试题：写一个固定容量同步容器，拥有put和get方法，以及getCount方法，
 * 能够支持2个生产者线程以及10个消费者线程的阻塞调用
 * <p>
 * 使用Lock和Condition来实现
 * 对比两种方式，Condition的方式可以更加精确的指定哪些线程被唤醒
 */
public class myContainer2<T> {
    LinkedList<T> conatiner = new LinkedList<>();
    final private int MAX = 10;
    int count = 0;

    private ReentrantLock lock = new ReentrantLock();
    private Condition producer = lock.newCondition();
    private Condition consumer = lock.newCondition();

    void put(T t) {
        try {
            lock.lock();
            while (conatiner.size() == MAX) { //想想为什么用while而不是用if？
                producer.await();
            }

            conatiner.add(t);
            ++count;
            consumer.signalAll(); //通知消费者线程进行消费
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    T get() {
        T t = null;
        try {
            lock.lock();
            while (conatiner.size() == 0) {
                consumer.await();
            }
            t = conatiner.removeFirst();
            count--;
            producer.signalAll(); //通知生产者进行生产
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return t;
    }

    int getCount() {
        return count;
    }


    public static void main(String[] args) {
        myContainer2<String> c = new myContainer2<>();

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 5; j++) System.out.println(c.get());
            }, "c" + i).start();
        }

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                for (int j = 0; j < 10; j++) c.put(Thread.currentThread().getName() + " " + j);
            }, "p" + i).start();
        }

    }
}
