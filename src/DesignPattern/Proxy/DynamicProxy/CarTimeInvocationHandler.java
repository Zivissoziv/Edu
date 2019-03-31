package DesignPattern.Proxy.DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by Ziv on 2019/3/30.
 */
public class CarTimeInvocationHandler implements InvocationHandler {

    /**
     * 中间类持有委托类对象的引用,这里会构成一种静态代理关系
     */
    private Object obj;

    /**
     * 有参构造器,传入委托类的对象
     *
     * @param obj 委托类的对象
     */
    public CarTimeInvocationHandler(Object obj) {
        this.obj = obj;
    }



    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("start time" + start);
        Object result = method.invoke(obj, args);
        long end = System.currentTimeMillis();
        System.out.println("end time" + end);
        return result;
    }
}
