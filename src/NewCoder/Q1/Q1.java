package NewCoder.Q1;

/**
 * Created by Ziv on 2019/1/23.
 * 在一个二维数组中（每个一维数组的长度相同），
 * 每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class Q1 {
    public static void main(String[] args) {
        int[][] a = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};
        System.out.println(Find(6,a));
    }

    public static boolean Find(int target, int[][] array) {
        //从左下坐标开始遍历
        int row = array.length - 1;
        int col = 0;
        while (col <= array[0].length - 1 && row >= 0) {
            if (target == array[row][col]) {
                return true;
            } else if (target > array[row][col]) {
                col++;
            } else {
                row--;
            }
        }
        return false;
    }

}
