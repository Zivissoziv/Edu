package DesignPattern.Factory.abstractFactory;

/**
 * Created by Ziv on 2019/3/27.
 */
public class Gun implements Weapen {
    @Override
    public void shoot() {
        System.out.println("Gun is shooting");
    }
}
