package NewCoder.Q40;

import java.util.ArrayList;

/**
 * Created by Ziv on 2019/2/17.
 * 找出所有和为S的连续正数序列
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 */
public class Q40 {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        //暴力
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        long now = System.currentTimeMillis();
        for (int i = 1; i < sum; i++) {
            int j = i + 1;
            while (j <= sum - 1) {
                if ((i + j) * (j - i + 1 ) / 2 == sum) {
                    ArrayList<Integer> par = new ArrayList<>();
                    int start = i;
                    while (start <= j) {
                        par.add(start);
                        start++;
                    }
                    res.add(par);
                    break;
                }
                if ((i + j) * (j - i) / 2 > sum) {
                    break;
                }
                j++;
            }
        }
        long then = System.currentTimeMillis();
        System.out.println(then-now);
        return res;
    }
}

class test{
    public static void main(String[] args) {
        Q40 q40 = new Q40();
        //Practise5做出了改进
        ArrayList<ArrayList<Integer>> arrayLists = q40.FindContinuousSequence(100000000);
        System.out.println(arrayLists.toString());
    }
}
