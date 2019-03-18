package Concurrent.C11;

import java.util.ArrayList;

/**
 * Created by Ziv on 2019/3/17.
 * 实现一个容器
 * 两个线程，一个往里写数据，一个监控，当监控到第一个线程写入5个数时，给出提示
 * 实现方式一：
 * 不足之处：t2线程的死循环很浪费cpu，如果有更多的线程写数据有可能造成数据不一致
 */
public class myContainner1 {
    volatile ArrayList<Integer> list = new ArrayList<>();

    void add(int i) {
        list.add(i);
        System.out.println("list + " + i);
    }

    int size() {
        return list.size();
    }
}

class test {
    public static void main(String[] args) {
        myContainner1 c = new myContainner1();
        new Thread(() -> {
            System.out.println("线程一启动");
            for (int i = 0; i < 10; i++) {
                c.add(i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            System.out.println("线程二启动");
            while (true) {
                if (c.size() == 5) {
                    break;
                }
            }
            System.out.println("t2 给出提示");
        }).start();
    }


}
