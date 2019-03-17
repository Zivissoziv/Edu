package NewCoder.Q24;

/**
 * Created by Ziv on 2019/2/12.
 * 输入一颗二叉树的跟节点和一个整数，
 * 打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下*一直到叶结点*所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前：说明采用深度优先遍历)
 */

import java.util.ArrayList;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }
}

public class Q24 {
    private ArrayList<ArrayList<Integer>> allList = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> path = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) {
            return allList;
        }

        //没访问到一个节点，都把当前节点添加到路径中，调整target的值
        target -= root.val;
        path.add(root.val);

        //当访问到根节点且target为0时，把结果添加到allList中
        if (target == 0 && root.left == null && root.right == null) {
            allList.add(new ArrayList<Integer>(path));
        }

        //否则继续遍历
        FindPath(root.left, target);
        FindPath(root.right, target);

        //关键！！
        //已到叶节点后会跳过两个递归函数到这里，此时要把最后一个节点从路径中删除，才能返回上层节点
        path.remove(path.size() - 1);
        return allList;
    }
}
