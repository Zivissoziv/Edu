package NewCoder.Q61;

import java.util.ArrayList;


/**
 * Created by Ziv on 2019/3/11.
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 */
public class Q61 {
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        if(size==0){
            return res;
        }
        int i = 0;
        int j = size - 1;
        for (; j < num.length; j++, i++) {
            res.add(getMax(num,i,j));
        }
        return res;
    }

    public int getMax(int[] num, int i, int j) {
        int max = num[i];
        while (i <= j) {
            if (num[i] > max) {
                max = num[i];
            }
            i++;
        }
        return max;
    }
}

class test{
    public static void main(String[] args) {
        Q61 q61 = new Q61();
        ArrayList<Integer> res = q61.maxInWindows(new int[]{1}, 3);
        System.out.println(res);
    }
}