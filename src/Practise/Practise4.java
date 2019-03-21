package Practise;

import java.util.Stack;

/**
 * Created by Ziv on 2019/3/17.
 * 模拟栈的压入弹出
 * 输入两个int[],判断第二个是否为第一个的弹出顺序之一
 */
public class Practise4 {
    public boolean stackJudge(int[] a, int[] b) {
        if (a.length != b.length) {
            return false;
        }
        Stack<Integer> s = new Stack<>();
        boolean flag = false;
        int i = 0;
        int j = 0;
        while (i < a.length) {
            s.push(a[i]);
            while (!s.isEmpty() && b[j] == s.peek()) {
                if (j == b.length - 1) {
                    flag = true;
                }
                s.pop();
                j++;
            }
            i++;
        }
        return flag;
    }

    public static void main(String[] args) {
        Practise4 practise4 = new Practise4();
        System.out.println(practise4.stackJudge(new int[]{1, 2, 3}, new int[]{1, 3, 2}));
    }
}


