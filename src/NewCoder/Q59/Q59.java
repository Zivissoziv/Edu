package NewCoder.Q59;

import java.util.Stack;

/**
 * Created by Ziv on 2019/2/27.
 */
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }
}
public class Q59 {
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        Stack<TreeNode> stack = new Stack<>();
        if(pRoot==null){
            return pRoot;
        }
        int i = 0;
        while(pRoot!=null||!stack.isEmpty()){
            while(pRoot!=null){
                stack.push(pRoot);
                pRoot = pRoot.left;
            }
            if(!stack.isEmpty()){
                i++;
                pRoot = stack.pop();
                if(i==k){
                    return pRoot;
                }
                pRoot = pRoot.right;
            }
        }
        return null;
    }
}
