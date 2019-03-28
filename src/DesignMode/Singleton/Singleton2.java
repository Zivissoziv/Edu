package DesignMode.Singleton;

/**
 * Created by Ziv on 2019/3/17.
 * 单例模式2：懒汉式(只适合单线程）
 */
public class Singleton2 {
    private static Singleton2 INSTANCE=null;

    private Singleton2(){

    }

    public static Singleton2 getINSTANCE(){
        if(INSTANCE==null){
            return new Singleton2();
        }
        return INSTANCE;
    }
}

class test2{
    public static void main(String[] args) {
        Singleton2 instance = Singleton2.getINSTANCE();
    }
}

