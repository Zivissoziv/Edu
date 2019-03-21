package Practise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Ziv on 2019/3/20.
 * 之字打印二叉树
 * 第一层：左—》右；第二层：右—》左
 */
public class Practise10 {
    void zprintgTree(TreeNode pRoot) {
        Queue<TreeNode> q = new LinkedList<>();
        ArrayList<Integer> layer = new ArrayList<>();
        int target = 1;
        int count = 0;
        boolean flag = true;
        q.offer(pRoot);

        while (!q.isEmpty()) {
            TreeNode tmp = q.poll();
            layer.add(tmp.val);
            count++;
            if (tmp.left != null) {
                q.add(tmp.left);
            }
            if (tmp.right != null) {
                q.add(tmp.right);
            }
            if (count == target) {
                target = q.size();
                if (flag) {
                    System.out.print(layer);
                } else {
                    System.out.print(reverse(layer));
                }
                count = 0;
                flag = !flag;
                layer = new ArrayList<>();
            }
        }
    }

    ArrayList reverse(ArrayList<Integer> arr) {
        int i = 0;
        int j = arr.size() - 1;
        while (i < j) {
            int tmp = arr.get(i);
            arr.set(i, arr.get(j));
            arr.set(j, tmp);
            i++;
            j--;
        }
        return arr;
    }

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
        Practise10 p10 = new Practise10();
        p10.zprintgTree(n1);
    }


}
