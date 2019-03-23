package REAL;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

/**
 * Created by Ziv on 2019/3/23.
 * 模拟一个ArrayList在并发情况下出现数据异常的场景
 */
public class Q11 {

//    ArrayList<Integer> arr = new ArrayList<>();
    Vector<Integer> arr = new Vector<>();

    void put(int i) {
        arr.add(i);
    }

    public static void main(String[] args) {
        Q11 q11 = new Q11();
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                for (int j=0;j<1000;j++){
                    q11.put(j);
                }
            }).start();
        }

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(q11.arr.size());
    }


}
