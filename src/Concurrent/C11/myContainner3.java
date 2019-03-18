package Concurrent.C11;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by Ziv on 2019/3/17.
 * 对myContainner的改进二
 * 用门闩(Latch)实现代替wait notify进行通知
 * 当不涉及同步，只是涉及线程通信的时候，用synchronized + wait/notify就显得太重了
 * 这时应该考虑countdownlatch/cyclicbarrier/semaphore
 */

public class myContainner3 {
    //添加volatile，使t2能够得到通知
    volatile List lists = new ArrayList();

    public void add(int i) {
        lists.add(i);
    }

    public int size() {
        return lists.size();
    }

    public static void main(String[] args) {
        myContainner3 c = new myContainner3();

        CountDownLatch latch = new CountDownLatch(1);

        new Thread(() -> {
            System.out.println("线程二启动");
            if (c.size() != 5) {
                try {
                    latch.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("线程二通知");
        }, "t2").start();


        new Thread(() -> {
            System.out.println("线程一启动");
            for (int i = 0; i < 10; i++) {
                c.add(i);
                if(c.size()==5){
                    latch.countDown();
                }
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"t1").start();
    }
}
