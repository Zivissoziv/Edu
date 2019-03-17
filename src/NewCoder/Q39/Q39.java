package NewCoder.Q39;

import java.util.HashMap;
import java.util.Iterator;


/**
 * Created by Ziv on 2019/2/17.
 * 一个整型数组里除了两个数字之外，其他的数字都出现了偶数次。请写程序找出这两个只出现一次的数字。
 * num1,num2分别为长度为1的数组。传出参数
 * 将num1[0],num2[0]设置为返回结果
 */
public class Q39 {
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        //暴力法
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                map.remove(array[i]);
            } else {
                map.put(array[i], 1);
            }
        }
        if (!map.isEmpty()) {
            Iterator<Integer> itr = map.keySet().iterator();
            while (itr.hasNext()) {
                num1[0] = itr.next();
                num2[0] = itr.next();
            }
        }
    }

    public void FindNumsAppearOnce2(int[] array, int num1[], int num2[]) {
        //异或法（空间复杂度为O(1)）


    }
}

class test {
    public static void main(String[] args) {
//        NewCoder.Q39 q39 = new NewCoder.Q39();
//        int[] ints = {1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 7, 8};
//        int[] num1 = {0};
//        int[] num2 = {0};
//        q39.FindNumsAppearOnce(ints,num1,num2);
//        System.out.println(num1[0]+"  "+num2[0]);


        int[] ints = {1, 2, 3, 4, 5, 6, 7, 1, 2, 3, 4, 5, 6};
        int bitResult = 0;
        for (int i = 0; i < ints.length; ++i) {
            bitResult ^= ints[i];
        }
        System.out.println(bitResult);

//        int a = 10;
//        int b = 9;
//        a = a^b;
//        b = b^a;
//        a = a^b;
//        System.out.println(a+" "+b);
    }
}
