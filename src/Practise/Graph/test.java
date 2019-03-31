package Practise.Graph;

/**
 * Created by Ziv on 2019/3/31.
 * 测试
 */
public class test {
    public static void main(String[] args) {
        Vertix v1 = new Vertix("A");
        Vertix v2 = new Vertix("B");
        Vertix v3 = new Vertix("C");
        Vertix v4 = new Vertix("D");
        Vertix v5 = new Vertix("E");

        Graph graph = new Graph();
        graph.setVertiNum(5);
        graph.addVertix(v1);
        graph.addVertix(v2);
        graph.addVertix(v3);
        graph.addVertix(v4);
        graph.addVertix(v5);
        graph.addEdge(v1, v2);
        graph.addEdge(v1, v3);
        graph.addEdge(v2, v3);
        graph.addEdge(v2, v4);
        graph.addEdge(v2, v5);
        graph.disPlay();

        graph.dfs(v1);
    }
}
