package DesignPattern.Proxy.StaticProxy;

/**
 * Created by Ziv on 2019/3/28.
 * 代理是一种类增强的方式
 * 以下是通过接口的方式实现静态代理
 * 要求代理对象和目标对象实现同一个接口
 */
public class test {
    public static void main(String[] args) {
        //通过层层嵌套的方式实现代理
        Car c = new Car();
        Moveable ctp = new CarTimeProxy(c);
        Moveable clp = new CarLogProxy(ctp);
        clp.movie();

    }

}
