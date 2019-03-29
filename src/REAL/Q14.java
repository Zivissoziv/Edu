package REAL;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Ziv on 2019/3/28.
 * <p>
 * 米哈游毒液喷射问题
 * 在65530*65530的地图上
 * 输入射击次数及每次射击的详情（射击点(x,y)，毒液距离）
 * 求出被毒液感染的区域面积
 * 如：
 * 2
 * 0 0 2
 * 1 1 2
 *
 * 输出7
 */
public class Q14 {


    public static void main(String[] args) {
        Q14 q14 = new Q14();
        Scanner sc = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> venoms = new ArrayList<>();
        String n = sc.nextLine();
        int maxIndex = 0;
        int minIndex = 65530;
        for (int i = 0; i < Integer.parseInt(n); i++) {
            String loc = sc.nextLine();
            String[] splits = loc.split(" ");
            ArrayList<Integer> venom = new ArrayList<>();
            int bx = Integer.valueOf(splits[0]);
            int by = Integer.valueOf(splits[1]);
            int vr = Integer.valueOf(splits[2]);
            int topX = bx + vr;
            if (topX > 65530) {
                topX = 65530;
            }
            int topY = by + vr;
            if (topY > 65530) {
                topY = 65530;
            }
            maxIndex = Math.max(maxIndex, Math.max(topX, topY));
            minIndex = Math.min(minIndex, Math.min(bx, by));
            venom.add(bx);
            venom.add(by);
            venom.add(topX);
            venom.add(topY);
            venoms.add(venom);
        }
        System.out.println(maxIndex);
        System.out.println(minIndex);
        int InfectedArea = q14.getInfectedArea(venoms, maxIndex + 1, minIndex);
        System.out.println(InfectedArea);
    }


    int getInfectedArea(ArrayList<ArrayList<Integer>> venoms, int maxIndex, int minIndex) {
        int[][] map = new int[maxIndex - minIndex][maxIndex - minIndex];
        for (ArrayList<Integer> venom : venoms) {
            int topX = venom.get(2) - minIndex;
            int topY = venom.get(3) - minIndex;
            for (int i = venom.get(0) - minIndex; i < topX; i++) {
                for (int j = venom.get(1) - minIndex; j < topY; j++) {
                    map[i][j] = 1;
                }
            }
        }

        int infectedAreaCount = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 1) {
                    infectedAreaCount++;
                }
            }
        }
        return infectedAreaCount;
    }
}
