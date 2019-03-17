package NewCoder.Q35;

import java.util.Stack;

/**
 * Created by Ziv on 2019/2/16.
 */

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Q35 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        Stack<ListNode> st1 = new Stack<>();
        Stack<ListNode> st2 = new Stack<>();

        while (pHead1 != null) {
            st1.push(pHead1);
            System.out.println("st1:" + pHead1.val);
            pHead1 = pHead1.next;
        }

        while (pHead2 != null) {
            st2.push(pHead2);
            System.out.println("st2:" + pHead2.val);
            pHead2 = pHead2.next;
        }

        ListNode res = new ListNode(0);
        if (!st1.isEmpty() && !st2.isEmpty()) {
            while (st1.peek() == st2.peek()) {
                res = st1.pop();
                st2.pop();
                System.out.println("res:" + res.val);
            }
            return res;
        } else {
            return null;
        }
    }
}

class test {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(7);
        n1.next = n2;
        n2.next = n3;
        n4.next = n5;
        n3.next = n6;
        n5.next = n6;
        n6.next = n7;
        Q35 q35 = new Q35();
        ListNode res = q35.FindFirstCommonNode(n1, n4);
        System.out.println(res.val);
    }
}
