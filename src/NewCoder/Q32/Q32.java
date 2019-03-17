package NewCoder.Q32;

import java.util.ArrayList;

/**
 * Created by Ziv on 2019/2/14.
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */
public class Q32 {
    public int GetUglyNumber_Solution(int index) {
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        int newRes = 1;
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(newRes);
        while (arr.size()<index) {
            newRes = Math.min(Math.min(arr.get(p2)*2,arr.get(p3)*3),arr.get(p5)*5);
            if(arr.get(p2) * 2 == newRes) p2++;
            if(arr.get(p3) * 3 == newRes) p3++;
            if(arr.get(p5) * 5 == newRes) p5++;
            arr.add(newRes);
        }
        return newRes;

    }
}
