package Concurrent.C15;

/**
 * Created by Ziv on 2019/3/18.
 * 有N张火车票，每张票都有一个编号
 * 同时有10个窗口对外售票
 * 请写一个模拟程序
 *
 *
 * 分析下面的程序可能会产生哪些问题？
 * 重复销售？超量销售？
 */

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;

public class T {
    //static Queue<String> tickets = new LinkedList<>();已测试会发生重复售票的问题，用ArrayList会发生超售的问题
    static Queue<String> tickets = new ConcurrentLinkedQueue<>();

    static {
        for (int i = 0; i < 1000; i++) tickets.add("票 编号：" + i);
    }

    public static void main(String[] args) {

        //isEmpty和poll各具有原子性，组合在一起可能会出问题
//        for (int i = 0; i < 10; i++) {
//            new Thread(() -> {
//                while (!tickets.isEmpty()) {
//                    try {
//                        TimeUnit.MILLISECONDS.sleep(10);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    String s = tickets.poll();
//                    System.out.println("销售了--" + s);
//                }
//            }).start();
//        }

        //下面这种些法更好
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                while (true) {
                    String s = tickets.poll();
                    try {
                        TimeUnit.MILLISECONDS.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (s == null) break;
                    else System.out.println("销售了--" + s);
                }
            }).start();
        }


    }
}
