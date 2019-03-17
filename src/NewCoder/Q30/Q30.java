package NewCoder.Q30;

/**
 * Created by Ziv on 2019/2/14.
 * 求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
 */
public class Q30 {
    public int NumberOf1Between1AndN_Solution(int n) {
        //1、暴力法
        int time = 0;
        for (int i = 1; i <= n; i++) {
            String s = String.valueOf(i);
            for(int j = 0;j<s.length();j++){
                if(s.charAt(j)=='1'){
                    time++;
                }
            }
        }
        return time;
    }
}

class test{
    public static void main(String[] args) {
        Q30 q30 = new Q30();
        int i = q30.NumberOf1Between1AndN_Solution(13);
        System.out.print(i+" ");
    }
}
