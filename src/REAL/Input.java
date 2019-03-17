package REAL;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Ziv on 2019/3/1.
 */
public class Input {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入数组长度");
        int length = input.nextInt();
        int[] arrs = new int[length];
        for (int i = 0; i < length; i++) {
            System.out.println("请输入第:"+(i+1)+"个");
            arrs[i] = input.nextInt();
        }
        System.out.println("您输入的数组是:" + Arrays.toString(arrs));

    }

}
