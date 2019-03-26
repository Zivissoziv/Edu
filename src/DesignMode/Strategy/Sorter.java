package DesignMode.Strategy;

/**
 * Created by Ziv on 2019/3/26.
 * 排序器
 */
public class Sorter {

    static void doSort(Object[] objs) {
        for (int i = 0; i < objs.length - 1; i++) {
            for (int j = 0; j < objs.length - 1; j++) {
                Comparable c1 = (Comparable) objs[j];
                Comparable c2 = (Comparable) objs[j + 1];
                if (c1.compareTo(c2) == 1) {
                    swap(objs, j, j+1);
                }
            }
        }
    }

    static void display(Object[] objs) {
        for (int i = 0; i < objs.length; i++) {
            System.out.print(objs[i] + " ");
        }
        System.out.println();
    }

    static private void swap(Object[] objs, int x, int y) {
        Object tmp = objs[x];
        objs[x] = objs[y];
        objs[y] = tmp;
    }


}
