package REAL;


/**
 * Created by Ziv on 2019/3/12.
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。
 * 例如 a b c e s f c s a d e e 这样的3 X 4 矩阵中包含一条字符串"bcced"的路径，
 * 但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 */

public class Q5 {
    public boolean hasPath(char[][] matrix, char[] str) {
        int row = matrix.length;
        int col = matrix[0].length;
        boolean[][] flag = new boolean[row][col];
        int ix = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (Helper(matrix, i, j, ix, flag, str)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean Helper(char[][] matrix, int i, int j, int ix, boolean[][] flag, char[] str) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length || matrix[i][j] != str[ix] || flag[i][j]) {
            return false;
        }
        if (ix == str.length - 1) return true;
        flag[i][j] = true;
        if (Helper(matrix, i + 1, j, ix + 1, flag, str) ||
                Helper(matrix, i - 1, j, ix + 1, flag, str) ||
                Helper(matrix, i, j + 1, ix + 1, flag, str) ||
                Helper(matrix, i, j - 1, ix + 1, flag, str)) {
            return true;
        }
        flag[i][j] = false;
        return false;
    }
}

class test5 {
    public static void main(String[] args) {
        Q5 q62 = new Q5();
        char[][] matrix = {{'a', 'b', 'c', 'e'}, {'s', 'f', 'c', 's'}, {'a', 'd', 'e', 'e'}};
        char[] str = {'b', 'c', 'c', 'e', 'd'};
        System.out.println(q62.hasPath(matrix, str));
    }
}