package Concurrent.ConcurrentContainer;

import java.util.Arrays;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.CountDownLatch;

/**
 * Created by Ziv on 2019/3/19.
 * 常见的几种并发HashMap以及性能测试
 */
public class ConcurrentMap {
    public static void main(String[] args) {
        //Map<String, String> map = new ConcurrentHashMap<>();//高并发但不排序
        Map<String, String> map = new ConcurrentSkipListMap<>(); //高并发并且排序

        //Map<String, String> map = new Hashtable<>();//线程安全，用synchronized实现
        //Map<String, String> map = new HashMap<>(); //线程不安全，key可以为null

        Random r = new Random();
        Thread[] ths = new Thread[100];
        CountDownLatch latch = new CountDownLatch(ths.length);
        long start = System.currentTimeMillis();
        for(int i=0; i<ths.length; i++) {
            ths[i] = new Thread(()->{
                for(int j=0; j<10000; j++) map.put("a" + r.nextInt(100000), "a" + r.nextInt(100000));
                latch.countDown();
            });
        }

        Arrays.asList(ths).forEach(t->t.start());
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
