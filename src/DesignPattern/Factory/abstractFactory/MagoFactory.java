package DesignPattern.Factory.abstractFactory;

/**
 * Created by Ziv on 2019/3/27.
 */
public class MagoFactory implements AbstractFactory {
    @Override
    public Vehicle createVehicle() {
        return new Car();
    }

    @Override
    public Weapen createWeapen() {
        return new Gun();
    }
}
