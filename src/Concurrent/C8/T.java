package Concurrent.C8;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ziv on 2019/3/17.
 * volatile能够保证变量的可见性，但是不能保证操作的原子性
 */
public class T {
    volatile int count = 0;

    /*synchronized*/ void m() {
        for (int i = 0; i < 10000; i++) count++;
    }

    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();
        T t = new T();
        for(int i=0; i<10; i++) {
            threads.add(new Thread(()->t.m(), "thread-"+i));
        }
        threads.forEach((o)->o.start());

        threads.forEach((o)->{
            try {
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println(t.count);
    }
}
