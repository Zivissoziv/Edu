package NewCoder.Q29;

/**
 * Created by Ziv on 2019/2/13.
 * 给一个数组，返回它的最大连续子序列的和，子向量的长度至少是1
 * 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
 */
public class Q29 {

    //法1：暴力解法时间复杂度为O(n^2)
    public int FindGreatestSumOfSubArray(int[] array) {
        int maxInt = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            int tmpMax = 0;
            for (int j = i; j < array.length; j++) {
                tmpMax += array[j];
                if (tmpMax > maxInt) {
                    maxInt = tmpMax;
                }
            }
        }
        return maxInt;
    }

    //法2：一般解法
    public int FindGreatestSumOfSubArray2(int[] array) {
        int maxInt = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
            if (sum > maxInt) {
                maxInt = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        return maxInt;
    }
}

class test {
    public static void main(String[] args) {
        Q29 q29 = new Q29();
        int i = q29.FindGreatestSumOfSubArray2(new int[]{6, -3, -2, 7, -15, 1, 2, 2});
        System.out.println(i);
    }
}