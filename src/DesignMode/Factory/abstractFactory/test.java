package DesignMode.Factory.abstractFactory;

/**
 * Created by Ziv on 2019/3/27.
 * 抽象工厂模式
 * 普通工厂模式在！产生新的产品系列！时容易产生工厂泛滥的情况
 * 抽象工厂模式在！产生新的产品品种！时需要改动的地方太多
 */
public class test {
    public static void main(String[] args) {
//        AbstractFactory f = new MagicFactory();
        AbstractFactory f = new MagoFactory();
        f.createVehicle().run();
        f.createWeapen().shoot();
    }
}
