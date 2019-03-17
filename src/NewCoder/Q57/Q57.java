package NewCoder.Q57;


/**
 * Created by Ziv on 2019/2/25.
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 */

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }
}

public class Q57 {
    //特殊先序遍历

    String Serialize(TreeNode root) {
        String res = "";
        if (root == null) {
            res += "#,";
            return res;
        } else {
            res += root.val + ",";
            res += Serialize(root.left);
            res += Serialize(root.right);
            return res;
        }
    }

    int index = -1;

    TreeNode Deserialize(String str) {
        index++;
        String[] node = str.split(",");
        TreeNode root = null;
        if (!node[index].equals("#")) {
            root = new TreeNode(Integer.valueOf(node[index]));
            root.left = Deserialize(str);
            root.right = Deserialize(str);
        }
        return root;
    }
}

class test {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;


        Q57 q57 = new Q57();
        String res = q57.Serialize(n1);
        TreeNode newTree = q57.Deserialize(res);
        String com = q57.Serialize(newTree);
        System.out.println(res);
        System.out.println(com);

    }
}
