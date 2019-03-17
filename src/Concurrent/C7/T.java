package Concurrent.C7;

/**
 * Created by Ziv on 2019/3/17.
 * volatile关键字的深入理解
 *
 * volatile 关键字，使一个变量在多个线程间可见
 * A B线程都用到一个变量，java默认是A线程中保留一份copy，这样如果B线程修改了该变量，则A线程未必知道
 * 使用volatile关键字，会让所有线程都会读到变量的修改值
 *
 * 参考JMM模型
 * 在下面的代码中，flag是存在于堆内存的t对象中
 * 当线程t1开始运行的时候，会把flag值从内存中读到t1线程的工作区，在运行过程中直接使用这个copy，并不会每次都去
 * 读取堆内存，这样，当主线程修改flag的值之后，t1线程感知不到，所以不会停止运行
 *
 * volatile并不能保证多个线程共同修改running变量时所带来的不一致问题，也就是说volatile不能替代synchronized
 */
public class T {
    /*volatile*/ boolean flag = true;
    void m1(){
        System.out.println("m1 start");
        while(flag){

        }
        System.out.println("m1 is end");
    }

    public static void main(String[] args) {
        T t = new T();
        new Thread(()->t.m1()).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.flag = false;
    }
}
