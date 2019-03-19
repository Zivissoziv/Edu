package Practise;

import java.util.*;

/**
 * Created by Ziv on 2019/3/19.
 * 实现一个函数找出字符流中第一个只出现一次的字符
 * 如当输入"google"的时候，只读到前两位返回"g"，读完时返回"l"
 */
public class Practise8 {

    Map<Character, Integer> map = new LinkedHashMap<>();

    public void insert(char c) {
        if (!map.containsKey(c)) {
            map.put(c, 1);
        } else {
            map.put(c, 2);
        }
    }


    public char FirstAppearingOnce() {
        char res = ' ';
        for (Character c : map.keySet()) {
            if (map.get(c) == 1) {
                res = c;
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Practise8 p8 = new Practise8();
        p8.insert('g');
        p8.insert('o');
        p8.insert('o');
        p8.insert('g');
        p8.insert('l');
        p8.insert('e');
        System.out.println(p8.FirstAppearingOnce());
    }
}
