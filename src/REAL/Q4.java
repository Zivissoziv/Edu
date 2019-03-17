package REAL;

/**
 * Created by Ziv on 2019/3/11.
 * 寻找所有质因数
 * 输入一个正整数，输出他的所有质因数
 * 如输入90，输出90=2*3*3*5
 */
public class Q4 {
    public void getPrimeNum(int a){
        int k = 2;
        System.out.print(a+"=");
        while(k<=a) {
            if (a % k == 0) {
                if(a/k==1){
                    System.out.print(k+"");
                }else {
                    System.out.print(k + "*");
                }
                a = a / k;
            }else {
                k++;
            }
        }
    }
}

class test{
    public static void main(String[] args) {
        Q4 q4 = new Q4();
        q4.getPrimeNum(168);
    }
}
