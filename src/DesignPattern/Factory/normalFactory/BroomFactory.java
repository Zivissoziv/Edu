package DesignPattern.Factory.normalFactory;

/**
 * Created by Ziv on 2019/3/27.
 */
public class BroomFactory {
    private BroomFactory(){
    };

    public static Broom getBroom(){
        return new Broom();
    }

}
