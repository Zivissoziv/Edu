package NewCoder.Q16;

/**
 * Created by Ziv on 2019/2/8.
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Q16 {
    public static ListNode Merge(ListNode list1, ListNode list2) {
        if(list1==null)
            return list2;
        if(list2==null)
            return list1;
        ListNode res = null;
        if(list1.val<list2.val){
            res = list1;
            res.next = Merge(list1.next, list2);
        }else{
            res = list2;
            res.next = Merge(list1, list2.next);
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(10);
        ListNode n2 = new ListNode(9);
        ListNode n3 = new ListNode(8);
        ListNode n4 = new ListNode(7);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        ListNode n5 = new ListNode(11);
        ListNode n6 = new ListNode(10);
        ListNode n7 = new ListNode(6);
        n5.next = n6;
        n6.next = n7;

        ListNode res = Merge(n1, n5);
        while(res!=null){
            System.out.print(res.val+" ");
            res = res.next;
        }
    }
}

