package NewCoder.Q54;


/**
 * Created by Ziv on 2019/2/24.
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

    public class Q54 {
        boolean isSymmetrical(TreeNode pRoot) {
            //1、递归，只要左子树和右子树相等
            if (pRoot == null) return true;
            return isSymmetrical(pRoot.left, pRoot.right);
        }

        private boolean isSymmetrical(TreeNode left, TreeNode right) {
            if (left == null && right == null) return true;
            if (left == null || right == null) return false;
            //对称满足的条件：
            return left.val == right.val &&
                    isSymmetrical(left.left, right.right) &&
                    isSymmetrical(left.right, right.left);

        }
    }
}
