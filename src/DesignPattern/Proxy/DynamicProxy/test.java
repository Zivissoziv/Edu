package DesignPattern.Proxy.DynamicProxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by Ziv on 2019/3/28.
 * 思考为什么需要动态代理？
 * 静态代理的缺点：
 * 1、首先观察静态代理，如果Moveable接口发生变化，CarLogProxy和CarTimeProxy都要发生改变，而且出现了大量的代码重复，增加了代码的维护难度
 * 2、静态代理对象只服务于一种类型的对象，如果要服务多类型的对象。势必要为每一种对象都进行代理，静态代理在程序规模稍大时就无法胜任了
 * <p>
 * 动态代理的优点：
 * 而动态代理的AOP（面向切面编程）的思想完美的解决了上述问题，我们不需要再考虑传入的是什么接口它里面有什么方法，
 * 而是只关注在些方法的开始或者结尾进行切面地添加处理逻辑，由系统通过反射机制自动补全和生成传入接口的对应实现，
 * 所谓的动态代理就是想办法根据接口或者目标对象计算出代理类的字节码然后加载进 JVM 中（实际计算的情况会很复杂，我们借助一些诸如 JDK 动态代理实现、CGLIB第三方库来完成。），
 * 使用动态代理可以灵活地对不同的对象进行“增强”，同时降低了代码的维护难度。
 * <p>
 * <p>
 * 常见应用：
 * Spring的AOP，加事务，加权限，加日志，远程RPC调用
 * <p>
 * 以下用Java的动态代理机制实现多级代理
 */
public class test {
    public static void main(String[] args) {
        Moveable m = new Car();
        InvocationHandler ctih = new CarTimeInvocationHandler(m);
        //以下得到第一个而增强类
        Moveable proxy = (Moveable) Proxy.newProxyInstance(
                //指定代理对象的类加载器
                m.getClass().getClassLoader(),
                //代理对象需要实现的接口，可以同时指定多个接口
                m.getClass().getInterfaces(),
                //方法调用的实际处理者，代理对象的方法调用都会转发到这里
                ctih);

        //可以把Proxy.newProxyInstance也写入InvocationHandler中，这样就不需要每次都进行转换，减少代码复用
        InvocationHandler ctlh = new CarLogInvocationHandler(proxy);
        proxy = (Moveable) Proxy.newProxyInstance(
                m.getClass().getClassLoader(),
                m.getClass().getInterfaces(),
                ctlh);

        proxy.movie();

    }
}
