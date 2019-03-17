package REAL;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Ziv on 2019/3/14.
 * 神测数据笔试题
 * 输入aabbbbcc
 * 返回a1b4c2
 */
public class Q6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        Q6 q6 = new Q6();
        q6.parseString2(str);
    }

    private void parseString(String str) {
        String[] split = str.split("");
        ArrayList<String> res = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            if (res.isEmpty()) {
                res.add(split[i]);
                res.add("1");
            } else if (res.get(res.size() - 2).equals(split[i])) {
                String newCount = Integer.parseInt(res.get(res.size() - 1)) + 1 + "";
                res.remove(res.size() - 1);
                res.add(newCount);
            } else {
                res.add(split[i]);
                res.add("1");
            }
        }
        for (String re : res) {
            System.out.print(re);
        }
    }

    private void parseString2(String str) {
        String[] split = str.split("");
        int i = 0;
        while (i < split.length) {
            int j = 1;
            int count = 1;
            System.out.print(split[i]);
            while (i + j < split.length && split[i].equals(split[i + j])) {
                count++;
                j++;
            }
            System.out.print(count);
            i = i + j;
        }
    }

}
