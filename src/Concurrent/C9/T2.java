package Concurrent.C9;

import java.util.concurrent.atomic.AtomicBoolean;
/**
 * Created by Ziv on 2019/3/17.
 *  验证AtomXXX是否具有可见性(不具有)
 */
public class T2 implements Runnable{
    AtomicBoolean flag = new AtomicBoolean(true);

    public /*synchronized*/ void run() {
        System.out.println("T2 start");
        while(flag.get()){

        }

        System.out.println("T2 stop");
    }

    public static void main(String[] args) {
        T2 t = new T2();
        Thread thread = new Thread(t);
        thread.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.flag = new AtomicBoolean(true);
    }
}
