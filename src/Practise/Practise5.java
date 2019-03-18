package Practise;

import java.util.ArrayList;

/**
 * Created by Ziv on 2019/3/18.
 * 和为s的连续数组Q21
 */
public class Practise5 {
    ArrayList<ArrayList<Integer>> getSum(int sum) {
        long now = System.currentTimeMillis();
        int i = 1;
        int j = 1;
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        while (i <= j) {
            int tmpSum = (i + j) * (j - i + 1) / 2;
            if (tmpSum == sum && i != j) {
                ArrayList<Integer> pr = new ArrayList<>();
                for (int k = i; k <= j; k++) {
                    pr.add(k);
                }
                res.add(pr);
                i++;
            } else if (tmpSum < sum) {
                j++;
            } else {
                i++;
            }
        }
        long then = System.currentTimeMillis();
        System.out.println(then-now);
        return res;
    }

    public static void main(String[] args) {
        Practise5 p5 = new Practise5();
        System.out.println(p5.getSum(100000000));
    }
}
