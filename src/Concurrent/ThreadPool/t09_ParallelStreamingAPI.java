package Concurrent.ThreadPool;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Ziv on 2019/3/23.
 * y用jdk8新特性ParallelStreamingAPI提高运算速度的
 */
public class t09_ParallelStreamingAPI {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            nums.add(100_0000 + random.nextInt(100_0000));
        }

        long start, end;

        start = System.currentTimeMillis();
        //用普通的stream
        nums.stream().forEach(v -> isPrime(v));
        end =System.currentTimeMillis();

        System.out.println(end - start);


        // 使用parallel stream api

        start = System.currentTimeMillis();
        //用高级的paralleStream
        nums.parallelStream().forEach(v -> isPrime(v));
        end =System.currentTimeMillis();

        System.out.println(end - start);
    }


    //判断一个数是否为质数
    static boolean isPrime(int num) {
        for (int i = 0; i < num / 2; i++) {
            if (num % 2 == 0) return false;
        }
        return true;
    }
}
