package NewCoder.Q13;

import java.util.Stack;

/**
 * Created by Ziv on 2019/2/1.
 * 输入一个链表，输出该链表中倒数第k个结点。
 */

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Q13 {
    public ListNode FindKthToTail(ListNode head, int k) {
        Stack<ListNode> s = new Stack<ListNode>();
        ListNode res = null;
        while (head.next != null) {
            s.push(head);
            head = head.next;
        }
        while (k > 0) {
            res = s.pop();
            k--;
        }
        return res;
    }

    public static void main(String[] args) {

    }
}

