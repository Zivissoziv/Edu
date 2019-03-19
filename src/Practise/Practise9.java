package Practise;

import java.util.HashSet;

/**
 * Created by Ziv on 2019/3/19.
 * 删除链表中的重复节点(deleteDup1重复节点保留)
 * (deleteDup2重复节点重复出现且不保留)
 */
public class Practise9 {
    ListNode deleteDup1(ListNode pHead) {
        HashSet<Integer> set = new HashSet<>();
        ListNode tmp = null;
        while (pHead.next != null) {
            if (!set.contains(pHead.val)) {
                set.add(pHead.val);
                tmp = pHead;
            } else {
                tmp.next = pHead.next;
                pHead = tmp;
            }
            pHead = pHead.next;
        }
        return pHead;
    }

    ListNode deleteDup2(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        //把!=改成==就变成deletDup1了而且空间复杂度要更小
        if (pHead.val != pHead.next.val) {
            pHead.next = deleteDup2(pHead.next);
            return pHead;
        } else {
            ListNode pNode = pHead;
            while (pNode != null && pNode.val == pHead.val) pNode = pNode.next;
            return deleteDup2(pNode);
        }
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(4);
        ListNode n6 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        Practise9 p9 = new Practise9();
        p9.deleteDup2(n1);
        while (n1 != null) {
            System.out.print(n1.val + " ");
            n1 = n1.next;
        }
    }
}
