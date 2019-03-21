package Concurrent.ConcurrentContainer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by Ziv on 2019/3/19.
 * <p>
 * TransferQueue：BlockQueue的一种
 * SynchronusQueue：TransferQ的一种特殊形式，没有容量，要求消费者立即消费
 */
public class ConcurrentBlockQueue2 {
    public static void main(String[] args) throws InterruptedException {
        LinkedTransferQueue<String> strs = new LinkedTransferQueue<>();
//        BlockingQueue<String> strs = new SynchronousQueue<>();

        //先启动消费者
        new Thread(() -> {
            try {
                System.out.println(strs.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        //主线程会把“aaa”直接交给一个等待的消费者
        //如果先用transfer再启动消费者，线程会阻塞
//        strs.transfer("aaa");

        //如果选择
        strs.put("aaa");


//        new Thread(() -> {
//            try {
//                System.out.println(strs.take());
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();
    }
}