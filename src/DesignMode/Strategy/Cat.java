package DesignMode.Strategy;

/**
 * Created by Ziv on 2019/3/26.
 * 猫类
 */
public class Cat implements Comparable {
    private int height;
    private int weight;
    private Comparator myComparator = new CatWeightComparator();

    @Override
    public String toString() {
        return "Cat{" +
                "height=" + height +
                ", weight=" + weight +
                '}';
    }

    public Cat(int height, int weight) {
        this.height = height;
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }


    @Override
    public int compareTo(Object o) {
        //重写CompareTo方法还是拓展性不太足，采取策略设计模式把以下方法抽象为Comparator
//        Cat c = (Cat) o;
//        if (this.getHeight() > c.getHeight()) return 1;
//        else if (this.getHeight() < c.getHeight()) return -1;
//        else return 0;

        return myComparator.compareTo(this,o);

    }
}
