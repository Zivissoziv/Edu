package NewCoder.Q12;

/**
 * Created by Ziv on 2019/2/1.
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class Q12 {
    public static int[] reOrderArray(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int leftindex = i - 1;
            int tmp = array[i];
            while (leftindex >= 0 && tmp % 2 != 0 && array[leftindex] % 2 == 0) {
                array[leftindex + 1] = array[leftindex];
                leftindex--;
            }
            array[leftindex + 1] = tmp;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] res = reOrderArray(new int[]{1, 2, 3, 8, 9, 8, 7});
        for (int re : res) {
            System.out.print(re + " ");
        }
    }
}

