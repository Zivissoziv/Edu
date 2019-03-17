package NewCoder.Q36;

/**
 * Created by Ziv on 2019/2/16.
 * 统计一个数字在排序数组中出现的次数。
 */
public class Q36 {
    public int GetNumberOfK(int[] array, int k) {
        //先用二分查找法找出该数字的位置
        int pos = find(array, k, 0, array.length - 1);
        System.out.println(pos);
        int time = 1;
        if (pos != -1) {
            int i = pos;
            while (i > 0) {
                if (array[i - 1] == k) {
                    time++;
                }
                i--;
            }
            i = pos;
            while (i < array.length-1) {
                if (array[i + 1] == k) {
                    time++;
                }
                i++;
            }
        }
        return time;
    }

    private int find(int[] array, int k, int start, int end) {
        if (end >= start) {
            int mid = (end + start+1) / 2;
            if (array[mid] == k) {
                return mid;
            }
            if (array[mid] < k) {
                return find(array, k, mid + 1, end);
            }
            if (array[mid] > k) {
                return find(array, k, start, mid - 1);
            }
        }
        return -1;
    }
}

class test {
    public static void main(String[] args) {
        Q36 q36 = new Q36();
        int i = q36.GetNumberOfK(new int[]{3}, 3);
        System.out.println(i);
    }
}


