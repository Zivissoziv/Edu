package DesignMode.Singleton;

/**
 * Created by Ziv on 2019/3/17.
 */
public enum Singleton3 {
    INSTANCE;
}

class test3{
    public static void main(String[] args) {
        Singleton3 instance = Singleton3.INSTANCE;
    }
}