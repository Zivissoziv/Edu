package NewCoder.Q6;

/**
 * Created by Ziv on 2019/1/26.
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class Q6 {
    public int minNumberInRotateArray(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int i = 0;
        int j = array.length - 1;
        while (j > i) {
            int mid = i + (j - i) / 2;
            if (array[j] < array[mid]) {
                i = mid + 1;
            } else if (array[j] == array[mid]) {
                j = j - 1;
            } else {
                j = mid;
            }
        }
        return array[i];
    }
}

class test {
    public static void main(String[] args) {
        Q6 q6 = new Q6();
        int i = q6.minNumberInRotateArray(new int[]{3, 4, 5, 6, 1, 2});
        System.out.println(i);
    }
}
