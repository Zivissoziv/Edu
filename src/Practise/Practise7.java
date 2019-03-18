package Practise;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by Ziv on 2019/3/18.
 * 设计一个容器，一个线程负责往里写数据，一个负责监控
 */
public class Practise7 {
    public static void main(String[] args) {
        container c = new container();
        CountDownLatch latch = new CountDownLatch(1);

        new Thread(() -> {
            System.out.println("t2 start!");

            if (c.getSize() != 5) {
                try {
                    latch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("t2 send a message!");

        }, "t2").start();

        new Thread(() -> {
            System.out.println("t1 start!");
            for (int i = 0; i < 10; i++) {
                c.add(i);
                if (c.getSize() == 5) {
                    latch.countDown();
                }
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t1").start();
    }


}


class container {
    volatile ArrayList<Integer> list = new ArrayList<>();

    void add(int i) {
        list.add(i);
        System.out.println(Thread.currentThread().getName() + " :" + i);
    }

    int getSize() {
        return list.size();
    }
}