package Practise.Graph;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by Ziv on 2019/3/31.
 * 无向图及图的深度优先遍历
 */
public class Graph {
    Vertix[] vertixs;
    int[][] adjMat;
    int currentSize = 0;


    //定义图的大小
    void setVertiNum(int n) {
        vertixs = new Vertix[n];
        adjMat = new int[n][n];
        for (int i = 0; i < n; i++) {
            adjMat[i][i] = 1;
        }
    }

    //向vertis中插入顶点
    void addVertix(Vertix v) {
        vertixs[currentSize] = v;
        currentSize++;
    }

    //更新邻接矩阵
    void addEdge(Vertix v1, Vertix v2) {
        int x = -1;
        int y = -1;
        for (int i = 0; i < vertixs.length; i++) {
            if (v1 == vertixs[i]) {
                x = i;
            }
        }
        for (int i = 0; i < vertixs.length; i++) {
            if (v2 == vertixs[i]) {
                y = i;
            }
        }
        adjMat[x][y] = 1;
        adjMat[y][x] = 1;
    }

    //打印邻接矩阵
    void disPlay() {
        for (int[] ints : adjMat) {
            System.out.println(Arrays.toString(ints));
        }
    }

    //深度优先遍历(输入起始顶点）
    void dfs(Vertix v) {
        //新建判断数组
        int[] isVeriified = new int[vertixs.length];

        //找到起始顶点的坐标
        int vIndex = -1;
        for (int i = 0; i < vertixs.length; i++) {
            if (vertixs[i] == v) {
                vIndex = i;
            }
        }

        //用栈开始遍历
        Stack<Vertix> s = new Stack();

        s.push(vertixs[vIndex]);
        isVeriified[vIndex] = 1;
        System.out.println(vertixs[vIndex]);
        out:
        while (!s.isEmpty()) {

            for (int i = 0; i < currentSize; i++) {
                if (adjMat[vIndex][i] == 1 && isVeriified[i] == 0) {
                    s.push(vertixs[i]);
                    vIndex = i;
                    isVeriified[i] = 1;
                    System.out.println(vertixs[i]);
                    continue out;
                }
            }

            //弹栈后，vIndex回退到栈顶元素
            s.pop();
            if (!s.isEmpty()) {
                for (int i = 0; i < vertixs.length; i++) {
                    if (vertixs[i] == s.peek()) {
                        vIndex = i;
                    }
                }
            }

        }

    }


}
