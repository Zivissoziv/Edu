package REAL;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Ziv on 2019/3/15.
 * 字符串的全排列
 */
public class Q7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        Q7 q7 = new Q7();
        ArrayList<String> res = q7.Permutation(str);
        System.out.println(res.toString());
    }

    ArrayList<String> Permutation(String str) {
        char[] chars = str.toCharArray();
        ArrayList<String> res = new ArrayList<>();
        helpFun(chars, 0, chars.length - 1, res);
        return res;
    }

    void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }

    void helpFun(char[] chars, int from, int to, ArrayList<String> res) {
        if (chars == null || from > to || from < 0) {
            return;
        }
        if (from == to) {
            if (!res.contains(String.valueOf(chars))) {
                res.add(String.valueOf(chars));
            }
        }
        for (int i = from; i <= to; i++) {
            swap(chars, i, from);
            helpFun(chars, from + 1, to, res);
            swap(chars, i, from);
        }
    }

}


