package Practise;

import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * Created by Ziv on 2019/2/28.
 * 倒打链表
 */

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }

}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }
}

public class Practise {
    //翻转链表
    ListNode ReverseListNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    //合并两条有序链表
    ListNode CombineTwoSortedListNode(ListNode n1, ListNode n2) {
        if (n1 == null) {
            return n2;
        }
        if (n2 == null) {
            return n1;
        }
        if (n1.val < n2.val) {
            n1.next = CombineTwoSortedListNode(n1.next, n2);
            return n1;
        } else {
            n2.next = CombineTwoSortedListNode(n1, n2.next);
            return n2;
        }
    }

    //输入两棵二叉树，判断A是不是B的子树
    //1、定义一个方法判断在确定根节点的情况下n2是否为n1的子树
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

    //再定义一个方法在不确定根节点的情况下是否相等
    boolean isChildTree(TreeNode n1, TreeNode n2) {
        boolean result = false;
        if (n1 != null && n2 != null) {
            if (n1.val == n2.val) {
                isSame(n1, n2);
            }
            if (!result) {
                result = isChildTree(n1.left, n2) || isChildTree(n1.right, n2);
            }
        }
        return result;
    }


    //求幂集
    public ArrayList<String> miSet(ArrayList<String> strings) {
        ArrayList<String> result = new ArrayList<>();
        result.add("");
        for (int i = 0; i < strings.size(); i++) {
            int size = result.size();
            for (int j = 0; j < size; j++) {
                String tmp = result.get(j);
                tmp += strings.get(i);
                result.add(tmp);
            }
        }
        return result;
    }

    //求二叉树树深（方法1，用队列参考层次遍历）
    int getDepth(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int depth = 0;
        int count = 0;
        int nextDept = 1;
        if (root == null) {
            return depth;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode tmp = queue.poll();
            count++;
            if (tmp.left != null) queue.offer(tmp.left);
            if (tmp.right != null) queue.offer(tmp.right);
            if (count == nextDept) {
                depth++;
                count = 0;
                nextDept = queue.size();
            }
        }
        return depth;
    }

    //求二叉树树深（方法二：用递归）
    int getDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getDepth2(root.left);
        int right = getDepth2(root.right);
        return Math.max(left, right)+1;
    }

    //求最大连续字串


}

class test {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n4.next = n5;
        Practise practise = new Practise();
//        ListNode newNode = practise.ReverseListNode(n1);
//        ListNode newNode = practise.CombineTwoSortedListNode(n1, n4);
//        while (newNode != null) {
//            System.out.println(newNode.val);
//            newNode = newNode.next;
//        }

        ArrayList<String> test = new ArrayList<>();
        test.add("a");
        test.add("b");
        test.add("c");

        ArrayList<String> res = practise.miSet(test);
        for (String re : res) {
            System.out.println(re);
        }

    }
}