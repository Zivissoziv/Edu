package REAL;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 平安科技笔试题，走瓷砖问题
 * 例如输入
 * =====
 * =====
 * =@===
 * =#=##
 * ===#=
 * end
 *
 * 输出
 * 20
 *
 * 代表一个长方形的房间，机器人从@的位置出发，=为白色瓷砖，#为黑色瓷砖，机器人只能走白色瓷砖
 * 求机器人能走到的白瓷砖数总和
 *
 * 解题思路：
 * 参考NewCoder里面的最后一题，机器人走格子问题
 * 不同点一：需要把用户的输入准确转换成房间地图，并获得机器人初始位置
 * 不同点二：阻碍的条件发生了变化
 */

public class Q10 {
    public int movingCount(ArrayList<ArrayList<String>> map, int beginx, int beginy) {
        int[][] flag = new int[map.size()][map.get(0).size()];
        return helper(map, beginx, beginy, flag);
    }

    public int helper(ArrayList<ArrayList<String>> map, int i, int j, int[][] flag) {
        if (i < 0 || j < 0 || i >= map.size() || j >= map.get(0).size() || flag[i][j] == 1 || map.get(i).get(j).equals("#"))
            return 0;
        flag[i][j] = 1;
        return helper(map, i + 1, j, flag) +
                helper(map, i - 1, j, flag) +
                helper(map, i, j - 1, flag) +
                helper(map, i, j + 1, flag) + 1;

    }

    public static void main(String[] args) {
        Q10 q10 = new Q10();
        Scanner sc = new Scanner(System.in);
        ArrayList<ArrayList<String>> map = new ArrayList<>();
        int count = 0;
        int beginx = 0;
        int beginy = 0;
        while (true) {
            String n = sc.nextLine();
            if (n.equals("end")) {
                break;
            }
            String[] strings = n.split("");
            ArrayList<String> layer = new ArrayList<>();
            for (int i = 0; i < strings.length; i++) {
                layer.add(strings[i]);
                if (strings[i].equals("@")) {
                    beginy = i;
                    beginx = count;
                }
            }
            count++;
            map.add(layer);
        }
        int ans =q10.movingCount(map,beginx,beginy);
        System.out.println(ans);

    }
}