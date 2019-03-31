package DesignPattern.Factory.abstractFactory;

/**
 * Created by Ziv on 2019/3/27.
 */
public class MagicFactory implements AbstractFactory {
    @Override
    public Vehicle createVehicle() {
        return new Broom();
    }

    @Override
    public Weapen createWeapen() {
        return new Stick();
    }
}
