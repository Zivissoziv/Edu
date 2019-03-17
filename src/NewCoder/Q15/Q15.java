package NewCoder.Q15;

/**
 * Created by Ziv on 2019/2/8.
 * 输入一个链表，反转链表后，输出新链表的表头。
 */


class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Q15 {
    public static ListNode ReverseList(ListNode head) {
        //反序的过程整个链表分成两个部分，前面的代表已反序，后面的代表待反序，反序和待反序
        ListNode pre = null;
        ListNode next = null;
        while(head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(10);
        ListNode n2 = new ListNode(9);
        ListNode n3 = new ListNode(8);
        ListNode n4 = new ListNode(7);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        ListNode newNode = ReverseList(n1);
        System.out.println(newNode.val);

    }

}
