package NewCoder.Q3;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Ziv on 2019/1/24.
 */
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Q3 {
    // 方法1
    // 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
    // 运用递归思路
    static ArrayList<Integer> list = new ArrayList<>();
    public  static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode != null) {
                printListFromTailToHead(listNode.next);
                list.add(listNode.val);
        }
        return list;
    }

    // 方法2
    // 用栈的方法，对链表元素进行压栈和弹栈处理
    public  static ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Integer> s1 = new Stack<>();
        while (listNode != null) {
            s1.push(listNode.val);
            listNode = listNode.next;
        }

        while(!s1.empty()){
            list.add(s1.pop());
        }
        return list;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(5);
        ListNode n4 = new ListNode(6);
        ListNode n5 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        ArrayList<Integer> result = printListFromTailToHead2(n1);
        System.out.println(result);
    }
}


