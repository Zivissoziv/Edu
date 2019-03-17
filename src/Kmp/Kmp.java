package Kmp;

/**
 * Created by Ziv on 2019/2/8.
 */
public class Kmp {

    private static void getNext(int[] next, String str) {
        next[0] = -1;//初始化
        int k = -1;//记录当前位置的next
        int j = 0;//用j纪录数组移动的位置
        while (j < str.length() - 1) {
            if (k == -1 || str.charAt(j) == str.charAt(k)) {
                j++;
                k++;
                next[j] = k;
            } else {
                k = next[k];
            }
        }
    }

    public static void main(String[] args) {
        String str = "ababba";
        int[] next = new int[str.length()];
        getNext(next, str);
        for (int i : next) {
            System.out.print(i + " ");
        }

    }
}
