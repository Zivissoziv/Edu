package DesignPattern.Strategy;

/**
 * Created by Ziv on 2019/3/26.
 * 狗类
 */
public class Dog implements Comparable{
    private int tailLong;

    @Override
    public String toString() {
        return "Dog{" +
                "tailLong=" + tailLong +
                '}';
    }

    public Dog(int tailLong) {
        this.tailLong = tailLong;
    }

    public int getTailLong() {
        return tailLong;
    }

    public void setTailLong(int tailLong) {
        this.tailLong = tailLong;
    }

    @Override
    public int compareTo(Object o) {
        Dog d = (Dog)o;
        if(this.getTailLong()>d.getTailLong()) return 1;
        else if(this.getTailLong()<d.getTailLong()) return -1;
        return 0;
    }
}
