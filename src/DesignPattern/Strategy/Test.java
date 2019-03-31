package DesignPattern.Strategy;

/**
 * Created by Ziv on 2019/3/26.
 * 测试类
 */
public class Test {
    public static void main(String[] args) {
        Cat[] cs = {new Cat(1,1),new Cat(3,3),new Cat(2,2),new Cat(1,1)};
        Dog[] ds = {new Dog(1),new Dog(3),new Dog(2),new Dog(8)};
        Sorter.doSort(cs);
        Sorter.display(cs);
        Sorter.doSort(ds);
        Sorter.display(ds);
    }
}
