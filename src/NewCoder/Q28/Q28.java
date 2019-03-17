package NewCoder.Q28;

import java.util.HashMap;

/**
 * Created by Ziv on 2019/2/13.
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class Q28 {
    public static int MoreThanHalfNum_Solution(int[] array) {
        int maxCount = 1;
        int maxNum = 1;
        HashMap<Integer, Integer> res = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (res.containsKey(array[i])) {
                int newCount = res.get(array[i])+1;
                res.put(array[i], newCount);
                if (newCount > maxCount) {
                    maxCount = newCount;
                    maxNum = array[i];
                }

            } else {
                res.put(array[i], 1);
            }

        }
        if (maxCount > array.length/2) {
            return maxNum;
        }else {
            return 0;
        }
    }



    public static void main(String[] args) {
        int i = MoreThanHalfNum_Solution(new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2});
        System.out.println(i);
    }
}

