package REAL;

import java.util.Scanner;

/**
 * Created by Ziv on 2019/3/16.
 * 找出数组中出现一半以上的数字
 */
public class Q8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入数组，以空格分割");
        String str = in.nextLine();
        String[] split = str.split(" ");
        int[] ints = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            ints[i] = Integer.parseInt(split[i]);
        }
        Q8 q8 = new Q8();
        q8.getHalf(ints);
    }

    void getHalf(int[] arr) {
        int count = 1;
        int res = arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    count = 1;
                    res = arr[i + 1];
                }
            }
        }
        int j = 0;
        for (int i : arr) {
            if (res == i) {
                j++;
            }
        }
        if (j > arr.length / 2) {
            System.out.println(res);
        } else {
            System.out.println("无" + " " + res);
            ;
        }
    }
}
