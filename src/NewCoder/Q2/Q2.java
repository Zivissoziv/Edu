package NewCoder.Q2;

/**
 * Created by Ziv on 2019/1/23.
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class Q2 {
    public static void main(String[] args) {
        StringBuffer a = new StringBuffer(" hello");
        System.out.println(replaceSpace2(a));
    }


    //方法1：创建一个新的StringBuffer，遇到" "替换为"%20"
    //缺点是空间复杂度较高
    public static String replaceSpace1(StringBuffer str) {
        StringBuffer out = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char b = str.charAt(i);
            if (str.charAt(i) == ' ')//单括号括起来的是char
            {
                out.append("%20");
            } else {
                out.append(b);
            }
        }
        return out.toString();
    }

    //方法2：在原来的StringBuffer上进行扩容，没有新增额外空间
    public static String replaceSpace2(StringBuffer str) {

        int spacenum = 0;//纪录空格出现次数
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                spacenum++;
            }
        }

        int oldlength = str.length();
        int newlength = oldlength + spacenum * 2;
        str.setLength(newlength);//对StringBuffer进行扩容
        int i = oldlength - 1;
        int j = newlength - 1;
        while (i > 0 || j > i) {//i，j指针向左移动
            if (str.charAt(i) == ' ') {
                str.setCharAt(j--, '0');
                str.setCharAt(j--, '2');
                str.setCharAt(j--, '%');
            } else {
                str.setCharAt(j--, str.charAt(i));
            }
            i--;
        }
        return str.toString();
    }
}
