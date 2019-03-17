package NewCoder.Q41;

import java.util.ArrayList;

/**
 * Created by Ziv on 2019/2/17.
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 */
public class Q41 {
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = array.length - 1; i > 0; i--) {
            int check = sum - array[i];
            for (int j = 0; j < i; j++) {
                if (array[j] == check) {
                    res.add(array[j]);
                    res.add(check);
                    return res;
                }
            }
        }
        return res;
    }
}
