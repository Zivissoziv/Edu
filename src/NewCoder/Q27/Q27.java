package NewCoder.Q27;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Ziv on 2019/2/12.
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 */
public class Q27 {

    static ArrayList<String> res = new ArrayList<>();
    public static ArrayList<String> Permutation(String str) {
        if(str==null) return null;
        char[] chars = str.toCharArray();
        HelpFun(chars,0);
        Collections.sort(res);
        return res;
    }

    private static void HelpFun(char[] chars, int i){
        if(i==chars.length-1){
            if(!res.contains(String.valueOf(chars))){
                res.add(new String(chars));
            }
        }else{
            for(int j=i;j<chars.length;j++){
                swap(chars,i,j);
                HelpFun(chars,i+1);
                swap(chars,i,j);
            }
        }
    }

    public static void swap(char[] cs, int i, int j) {
        char temp = cs[i];
        cs[i] = cs[j];
        cs[j] = temp;
    }



    public static void main(String[] args) {
        System.out.println(Permutation("aa"));
    }
}

//这一段就是回溯法，这里以"abc"为例

//递归的思想与栈的入栈和出栈是一样的,某一个状态遇到return结束了之后，会回到被调用的地方继续执行

//1.第一次进到这里是ch=['a','b','c'],list=[],i=0，我称为 状态A ，即初始状态
//那么j=0，swap(ch,0,0)，就是['a','b','c']，进入递归，自己调自己，只是i为1，交换(0,0)位置之后的状态我称为 状态B
//i不等于2，来到这里，j=1，执行第一个swap(ch,1,1)，这个状态我称为 状态C1 ,再进入fun函数，此时标记为T1，i为2，那么这时就进入上一个if，将"abc"放进list中
/////////////-------》此时结果集为["abc"]

//2.执行完list.add之后，遇到re               turn，回退到T1处，接下来执行第二个swap(ch,1,1)，状态C1又恢复为状态B
//恢复完之后，继续执行for循环，此时j=2,那么swap(ch,1,2),得到"acb"，这个状态我称为C2,然后执行fun，此时标记为T2,发现i+1=2,所以也被添加进结果集，此时return回退到T2处往下执行
/////////////-------》此时结果集为["abc","acb"]
//然后执行第二个swap(ch,1,2)，状态C2回归状态B,然后状态B的for循环退出回到状态A

//             a|b|c(状态A)
//               |
//               |swap(0,0)
//               |
//             a|b|c(状态B)
//             /  \
//   swap(1,1)/    \swap(1,2)  (状态C1和状态C2)
//           /      \
//         a|b|c   a|c|b

//3.回到状态A之后，继续for循环，j=1,即swap(ch,0,1)，即"bac",这个状态可以再次叫做状态A,下面的步骤同上
/////////////-------》此时结果集为["abc","acb","bac","bca"]

//             a|b|c(状态A)
//               |
//               |swap(0,1)
//               |
//             b|a|c(状态B)
//             /  \
//   swap(1,1)/    \swap(1,2)  (状态C1和状态C2)
//           /      \
//         b|a|c   b|c|a

//4.再继续for循环，j=2,即swap(ch,0,2)，即"cab",这个状态可以再次叫做状态A，下面的步骤同上
/////////////-------》此时结果集为["abc","acb","bac","bca","cab","cba"]

//             a|b|c(状态A)
//               |
//               |swap(0,2)
//               |
//             c|b|a(状态B)
//             /  \
//   swap(1,1)/    \swap(1,2)  (状态C1和状态C2)
//           /      \
//         c|b|a   c|a|b

//5.最后退出for循环，结束。