package DesignMode.Factory.abstractFactory;

/**
 * Created by Ziv on 2019/3/27.
 */
public class Car implements Vehicle{
    @Override
    public void run() {
        System.out.println("Car is running");
    }
}
