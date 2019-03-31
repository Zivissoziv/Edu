package DesignPattern.Factory.abstractFactory;

/**
 * Created by Ziv on 2019/3/27.
 */
public class Stick implements Weapen {
    @Override
    public void shoot() {
        System.out.println("Stick is shooting...");
    }
}
