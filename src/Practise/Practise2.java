package Practise;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Ziv on 2019/3/3.
 */

public class Practise2 {
    //求连续子数组的最大和
//    int getMax(int[] array) {
//        int max = 0;
//        int tmp = 0;
//        for (int i = 0; i < array.length; i++) {
//            tmp += array[i];
//            if (tmp > max) {
//                max = tmp;
//            }
//            if (tmp < 0) {
//                tmp = 0;
//            }
//        }
//        return max;
//    }

    //1~nz中,1出现的次数
//    public int NumberOf1Between1AndN_Solution(int n) {
//        int num = 0;
//        for (int i = 1; i <= n; i++) {
//            String str = String.valueOf(i);
//            for(int j =0;j<str.length();j++){
//                if(str.charAt(j)=='1'){
//                    num++;
//                }
//            }
//        }
//        return num;
//    }

//    //输入一个整型数组，把数组排成最小的数输出
//    public String PrintMinNumber(int[] numbers) {
//        for (int i = 0; i < numbers.length; i++) {
//            for (int j = i + 1; j < numbers.length; j++) {
//                String ab = String.valueOf(numbers[i]) + String.valueOf(numbers[j]);
//                String ba = String.valueOf(numbers[j]) + String.valueOf(numbers[i]);
//                if (Integer.valueOf(ab) > Integer.valueOf(ba)) {
//                    int tmp = numbers[i];
//                    numbers[i] = numbers[j];
//                    numbers[j] = tmp;
//                }
//            }
//        }
//        String res = "";
//        for (int i = 0; i < numbers.length; i++) {
//            res += numbers[i] + "";
//        }
//        return res;
//    }
//
//    //字符串的全排序
//    ArrayList<String> res = new ArrayList<>();
//
//    public ArrayList<String> Permutation(String str) {
//
//        char[] strs = str.toCharArray();
//        helpFun(strs, 0, str.length() - 1);
//        return res;
//    }
//
//    public void helpFun(char[] str, int start, int end) {
//        if (start == end) {
//            res.add(new String(str));
//        }
//        for (int i = start; i <= end; i++) {
//            swep(str, i, start);
//            helpFun(str, start + 1, end);
//            swep(str, start, i);
//        }
//    }
//
//
//    public void swep(char[] str, int i, int j) {
//        char tmp = str[i];
//        str[i] = str[j];
//        str[j] = tmp;
//    }

    //丑数
    public int GetUglyNumber_Solution(int index) {
        //输出第i个丑数
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        int newRes = 1;
        ArrayList<Integer> res = new ArrayList<>();
        res.add(1);
        while (res.size() < index) {
            newRes = Math.min(res.get(p2) * 2, Math.min(res.get(p3) * 3, res.get(p5) * 5));
            if (newRes == res.get(p2) * 2) p2++;
            if (newRes == res.get(p3) * 3) p3++;
            if (newRes == res.get(p5) * 5) p5++;
            res.add(newRes);
        }
        return newRes;
    }

    public static void main(String[] args) {
        Practise2 p2 = new Practise2();
//        Scanner in = new Scanner(System.in);
//        System.out.println("请输入数组长度:");
//        int length = in.nextInt();
//        int[] arr = new int[length];
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = in.nextInt();
//        }
//        System.out.println("最大值是: ");
//        int max = p2.getMax(arr);
//        System.out.print(max);

//        System.out.println(p2.NumberOf1Between1AndN_Solution(10));

//        System.out.println(p2.PrintMinNumber(new int[]{3, 32, 321}));

//        System.out.println(p2.Permutation("abc"));


    }
}
