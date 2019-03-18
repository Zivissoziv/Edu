package Concurrent.C11;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * Created by Ziv on 2019/3/17.
 * 对myContainner的改进一
 * 用wait和notify实现
 * 注意wait操作会时放对象锁，但notify不会
 */
public class myContainner2 {
    ArrayList<Integer> list = new ArrayList<>();

    void add(int i) {
        list.add(i);
        System.out.println("list + " + i);
    }

    int size() {
        return list.size();
    }
}

class test2 {
    public static void main(String[] args) {
        myContainner2 c = new myContainner2();
        new Thread(() -> {
            System.out.println("线程二启动");
            synchronized (c) {
                if (c.size() != 5) {
                    try {
                        c.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程二通知");
                    c.notify();
                }
            }
        }, "t2").start();


        new Thread(() -> {
            System.out.println("线程一启动");
            synchronized (c) {
                for (int i = 0; i < 10; i++) {
                    c.add(i);
                    if (c.size() == 5) {
                        c.notify();
                        try {
                            c.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        },"t1").start();
    }


}
