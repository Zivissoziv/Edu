package NewCoder.Q42;


/**
 * Created by Ziv on 2019/2/17.
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
 */
public class Q42 {
    public String LeftRotateString(String str, int n) {
        if(str.length()==0){
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = n; i < str.length(); i++) {
            stringBuffer.append(str.charAt(i));
        }
        for (int i = 0;i<n;i++){
            stringBuffer.append(str.charAt(i));
        }
        String s = stringBuffer.toString();
        return s;
    }
}

class test{
    public static void main(String[] args) {
        Q42 q42 = new Q42();
        String res = q42.LeftRotateString("", 3);
        System.out.println(res);
    }
}
