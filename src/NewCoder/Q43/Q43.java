package NewCoder.Q43;

import java.util.Stack;

/**
 * Created by Ziv on 2019/2/18.
 * 翻转单词顺序，例如“student. a am I”翻转后输出“I am a student.”
 */
public class Q43 {
    //方法1：借助栈
    public String ReverseSentence(String str) {
        if (str.trim().equals("")) {
            return str;
        }
        Stack<String> stack = new Stack<>();
        String newstr = str.trim();
        String[] strings = newstr.split(" ");
        for (int i = 0; i < strings.length; i++) {
            stack.push(strings[i]);
        }
        String res = "";
        while (!stack.isEmpty()) {
            res = res + " " + stack.pop();
        }
        return res;
    }


    //方法2：先反转整个句子然后一次翻转每个单词
    //根据空格来确定单词的起始和终止位置

    public String ReverseSentence2(String str) {
        char[] chars = str.toCharArray();
        reverse(chars, 0, chars.length - 1);
        int blank = -1;
        for(int i = 0;i < chars.length;i++){
            if(chars[i] == ' '){
                int nextBlank = i;
                reverse(chars,blank + 1,nextBlank - 1);
                blank = nextBlank;
            }
        }
        reverse(chars,blank + 1,chars.length - 1);//最后一个单词单独进行翻转
        return new String(chars);

    }

    private void reverse(char[] chars, int i, int j) {
        while (i < j) {
            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
            i++;
            j--;
        }
    }

}

class test{
    public static void main(String[] args) {
        Q43 q43 = new Q43();
        String s = q43.ReverseSentence2(" student. a am I");
        System.out.println(s);
    }
}
