package DesignMode.Proxy.StaticProxy;

/**
 * Created by Ziv on 2019/3/28.
 */
public class CarLogProxy implements Moveable {
    Moveable m;

    public CarLogProxy(Moveable m){
        this.m = m;
    }


    @Override
    public void movie() {
        System.out.println("Log begin...");
        m.movie();
        System.out.println("Log end...");
    }
}
