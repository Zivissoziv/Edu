package Practise;

/**
 * Created by Ziv on 2019/3/18.
 * 左旋转字符串
 * "abcdef"，3——》"defabc"
 */
public class Practise6 {
    String leftRotateString(String str, int n) {
        if(n>str.length()-1){
            System.out.println("输入错误！");
        }
        char[] chars = str.toCharArray();
        swap(chars,0,n-1);
        swap(chars,n,chars.length-1);
        swap(chars,0,chars.length-1);
        return new String(chars);
    }

    void swap(char[] chars, int i, int j) {
        while (i < j) {
            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        Practise6 p6 = new Practise6();
        System.out.println(p6.leftRotateString("abcdef",3));
    }
}
