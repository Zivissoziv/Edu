package NewCoder.Q58;

import java.util.Stack;

/**
 * Created by Ziv on 2019/2/25.
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。
 * 例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。
 */

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }
}

//因为是二叉搜索树，所以其中序遍历一定是有序的
public class Q58 {

    int index = 0;

    TreeNode KthNode(TreeNode pRoot, int k) {
        return null;
    }

    public void checkStack(TreeNode pRoot){
        Stack<TreeNode> stack= new Stack<>();
        while(pRoot!=null||!stack.empty()) {
            while(pRoot!=null) {
                stack.push(pRoot);
                pRoot=pRoot.left;
            }
            if(!stack.empty()) {
                pRoot=stack.pop();
                System.out.print(pRoot.val+" ");
                pRoot=pRoot.right;
            }
        }
    }
}

class test {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(7);
        TreeNode n4 = new TreeNode(2);
        TreeNode n5 = new TreeNode(4);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(8);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        Q58 q58 = new Q58();
        q58.checkStack(n1);
    }
}
