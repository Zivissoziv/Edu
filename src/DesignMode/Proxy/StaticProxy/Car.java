package DesignMode.Proxy.StaticProxy;

/**
 * Created by Ziv on 2019/3/28.
 */
public class Car implements Moveable {
    @Override
    public void movie() {
        System.out.println("Car is moving...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
