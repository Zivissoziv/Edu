package NewCoder.Q2;

import java.util.HashMap;

/**
 * Created by Ziv on 2019/1/24.
 */
public class Q2a {
    public static void main(String[] args) {
        //统计每个字母出现的次数
        String str = "AAABBBCCC";

        HashMap<Character, Integer> map = new HashMap<>();

        char[] chars = str.toCharArray();

        for (char c : chars) {
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }else{
                map.put(c,1);
            }
        }

        System.out.println(map);
    }
}
