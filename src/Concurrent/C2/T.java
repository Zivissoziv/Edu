package Concurrent.C2;

/**
 * Created by Ziv on 2019/3/17.
 * 都是针对T对象进行操作
 * 不加synchronized的情况下可能会出现count的数据不一致
 */
public class T implements Runnable{
    private int count = 10;

    public /*synchronized*/ void run() {

        count--;

        System.out.println(Thread.currentThread().getName() + " count = " + count);
    }

    public static void main(String[] args) {
        T t = new T();
        for(int i=0; i<5; i++) {
            new Thread(t, "THREAD" + i).start();
        }
    }
}
