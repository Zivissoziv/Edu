package DesignMode.Proxy.StaticProxy;

/**
 * Created by Ziv on 2019/3/28.
 */
public class CarTimeProxy implements Moveable {

    Moveable m;

    public CarTimeProxy(Moveable m){
        this.m = m;
    }


    @Override
    public void movie() {
        long start = System.currentTimeMillis();
        System.out.println("start time"+start);
        m.movie();
        long end = System.currentTimeMillis();
        System.out.println("end time"+end);
    }
}
