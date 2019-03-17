package NewCoder.Q63;

/**
 * Created by Ziv on 2019/3/12.
 * 地上有一个m行和n列的方格。
 * 一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。
 * 请问该机器人能够达到多少个格子？
 */
public class Q63 {
    public int movingCount(int threshold, int rows, int cols) {
        int[][] flag = new int[rows][cols];
        return helper(threshold, 0, 0, rows, cols, flag);
    }

    public int helper(int threshold, int i, int j, int rows, int cols, int[][] flag) {
        if (i < 0 || j < 0 || i >= rows || j >= cols || flag[i][j] == 1 || numSum(i) + numSum(j) > threshold) return 0;
        flag[i][j] = 1;
        return helper(threshold, i + 1, j, rows, cols, flag) +
                helper(threshold, i - 1, j, rows, cols, flag) +
                helper(threshold, i, j - 1, rows, cols, flag) +
                helper(threshold, i, j + 1, rows, cols, flag) + 1;

    }


    int numSum(int i) {
        int sum = 0;
        while (i > 0) {
            sum += i % 10;
            i = i / 10;
        }
        return sum;
    }

}

class test {
    public static void main(String[] args) {
        Q63 q63 = new Q63();
        int i = q63.numSum(100);
        System.out.println(i);

    }
}
