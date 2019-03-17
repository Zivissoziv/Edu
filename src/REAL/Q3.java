package REAL;

/**
 * Created by Ziv on 2019/3/9.
 */

import java.util.HashMap;
import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<Integer, Integer> a = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int pa = sc.nextInt();
            if(!a.containsKey(pa)){
                a.put(pa, 1);
            }else {
                a.put(pa, (a.get(pa)+1));
            }

        }
        int res = -1;
        for (int i = 0; i < n - 1; i++) {
            int pb = sc.nextInt();
            if (a.containsKey(pb)) {
                if(a.get(pb)-1==0){
                    a.remove(pb);
                }else {
                    a.put(pb,(a.get(pb)-1));
                }
            }
        }
        for (Integer v : a.keySet()) {
            System.out.println(v+"");
        }
    }
}
