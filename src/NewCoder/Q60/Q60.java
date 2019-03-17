package NewCoder.Q60;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by Ziv on 2019/2/27.
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 */
public class Q60 {
    ArrayList<Integer> res = new ArrayList<>();

    public void Insert(Integer num) {
        res.add(num);
        res.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
    }

    public Double GetMedian() {
        int length = res.size();
        if (length == 0) {
            return null;
        }
        if (length == 1) {
            return (double) (res.get(0));
        }
        if (res.size() % 2 == 0) {
            return  (((double)(res.get(length / 2-1)) + (double)(res.get(length / 2))) / 2);
        } else {
            return (double)(res.get(length / 2));
        }
    }
}

class test{
    public static void main(String[] args) {
        Q60 q60 = new Q60();
        q60.Insert(5);
        q60.Insert(2);
        q60.Insert(3);
        System.out.println(q60.GetMedian());

    }
}
