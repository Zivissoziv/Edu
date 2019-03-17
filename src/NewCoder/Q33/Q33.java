package NewCoder.Q33;

import java.util.HashMap;

/**
 * Created by Ziv on 2019/2/15.
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,
 * 并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 */
public class Q33 {
    public int FirstNotRepeatingChar(String str) {
        HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
        for (int i = 0; i < str.length(); i++) {
            if (hashMap.containsKey(str.charAt(i))) {
                hashMap.put(str.charAt(i), hashMap.get(str.charAt(i))+1);
            } else {
                hashMap.put(str.charAt(i), 1);
            }
        }

        for (int i = 0; i < str.length(); i++) {
            System.out.println(str.charAt(i)+" "+hashMap.get(str.charAt(i)));
        }
        return -1;
    }
}
class test{
    public static void main(String[] args) {
        Q33 q33 = new Q33();
        int google = q33.FirstNotRepeatingChar("google");
        System.out.println(google);

    }
}
