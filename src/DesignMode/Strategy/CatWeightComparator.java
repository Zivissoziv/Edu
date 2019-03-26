package DesignMode.Strategy;

/**
 * Created by Ziv on 2019/3/26.
 * 策略模式
 */
public class CatWeightComparator implements Comparator {
    @Override
    public int compareTo(Object o1, Object o2) {
        Cat c = (Cat) o1;
        Cat c2 = (Cat) o2;
        if (c.getWeight() < c2.getHeight()) return 1;
        else if (c.getWeight() > c2.getHeight()) return -1;
        else return 0;
    }
}
