package Concurrent.C14;

import java.util.concurrent.TimeUnit;

/**
 * Created by Ziv on 2019/3/18.
 * ThreadLocal线程局部变量
 * <p>
 * 不需要线程之间共享的变量可以用ThreadLocal修饰
 * ThreadLocal是使用空间换时间，synchronized是使用时间换空间
 * 比如在hibernate中session就存在与ThreadLocal中，避免synchronized的使用
 */
public class T {
    //volatile static Person p = new Person();
    static ThreadLocal<Person> p = new ThreadLocal<>();

    public static void main(String[] args) {

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(p.get());
        }).start();

        //即使在这里new了一个新person，t1也获取不到
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            p.set(new Person());
        }).start();
    }

}

class Person {
    String name = "zhangsan";

}

