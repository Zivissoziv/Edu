package DesignPattern.Factory.normalFactory;

/**
 * Created by Ziv on 2019/3/27.
 * 用一个工厂类管理和控制对象的创建
 */
public class test {
    public static void main(String[] args) {
        CarFactory.getCar().run();
        BroomFactory.getBroom().run();
    }
}
