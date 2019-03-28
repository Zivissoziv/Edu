package DesignMode.Singleton;

/**
 * Created by Ziv on 2019/3/17.
 * 单例模式1：饿汉式
 */
public class Singleton1 {
    private static Singleton1 INSTANCE = new Singleton1();

    private Singleton1(){

    }

    public static Singleton1 getINSTANCE(){
        return INSTANCE;
    }

}


class test{
    public static void main(String[] args) {
        Singleton1 instance = Singleton1.getINSTANCE();
    }
}