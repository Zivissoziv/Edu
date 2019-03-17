package NewCoder.Q37;

/**
 * Created by Ziv on 2019/2/16.
 */
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }
}

public class Q37 {
    public int TreeDepth(TreeNode root) {
        int res = 0;
        if (root != null) {
            res += 1;
        }
        if (root.left != null) {
            res += TreeDepth(root.left);
        }
        if (root.right != null) {
            res += TreeDepth(root.right);
        }
        return res;
    }
}

class test {
    public static void main(String[] args) {
        for (int i = 0; i < 1000000; i++) {
            if(i%3==1){
                int j = i-i/3-1;
                if(j%2==1){
                    System.out.println(j);
                }
            }
        }
    }
}
