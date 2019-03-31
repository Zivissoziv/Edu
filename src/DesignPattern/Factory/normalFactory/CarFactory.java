package DesignPattern.Factory.normalFactory;

/**
 * Created by Ziv on 2019/3/27.
 */
public class CarFactory {
    private CarFactory(){
    };

    public static Car getCar(){
        return new Car();
    }

}
