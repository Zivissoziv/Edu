package NewCoder.Q17;

/**
 * Created by Ziv on 2019/2/9.
 */

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }
}

public class Q17 {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        } else {

            //判断根节点是否相同,根节点相同就到根节点下去找
            if (root1.val == root2.val) {
                return isSame(root1, root2);
                //否则到左孩子或者右孩子去找
            } else {
                return HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
            }
        }
    }

    boolean isSame(TreeNode n1, TreeNode n2) {
        if (n2 == null) {
            return true;
        }

        if (n1 == null) {
            return false;
        }

        if (n1.val != n2.val) {
            return false;
        }

        return isSame(n1.left, n2.left) && isSame(n1.right, n2.right);
    }

    public static void main(String[] args) {
        System.out.println(false||false);
    }
}

