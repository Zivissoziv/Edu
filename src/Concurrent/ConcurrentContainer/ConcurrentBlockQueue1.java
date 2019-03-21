package Concurrent.ConcurrentContainer;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by Ziv on 2019/3/19.
 * 并发队列为三大种，
 * 普通并发队列
 * 阻塞并发队列（比普通队列多了队列空或满时的操作，take和put）
 * 延迟队列
 *
 * 以下主要针对几种阻塞并发队列
 */
public class ConcurrentBlockQueue1 {
    static BlockingQueue<String> strs = new LinkedBlockingQueue<>();//链表实现
    //static BlockingQueue<String> strs = new ArrayBlockingQueue<>(10);//数组实现，可以设定初始大小

    static Random r = new Random();

    public static void main(String[] args) {
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    strs.put("a" + i); //如果满了，就会等待
                    TimeUnit.MILLISECONDS.sleep(r.nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "p1").start();

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                for (; ; ) {
                    try {
                        System.out.println(Thread.currentThread().getName() + " take -" + strs.take()); //如果空了，就会等待
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, "c" + i).start();

        }
    }
}
