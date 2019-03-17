package REAL;


import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Ziv on 2019/3/16.
 * 二叉树的层次遍历
 */

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int i){
        this.val = i;
    }
}

public class Q9 {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        Q9 q9 = new Q9();
        q9.layerPrint(n1);
    }

    void layerPrint(TreeNode root){
        if(root==null){
            return;
        }
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while(!que.isEmpty()){
            TreeNode tmp = que.poll();
            System.out.print(tmp.val+" ");
            if(tmp.left!=null){
                que.add(tmp.left);
            }
            if(tmp.right!=null){
                que.add(tmp.right);
            }
        }
    }
}
