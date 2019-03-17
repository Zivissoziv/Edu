package NewCoder.Q45;

/**
 * Created by Ziv on 2019/2/19.
 * 每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。
 * HF作为牛客的资深元老,自然也准备了一些小游戏。其中,有个游戏是这样的:首先,让小朋友们围成一个大圈。
 * 然后,他随机指定一个数m,让编号为0的小朋友开始报数。每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,
 * 从他的下一个小朋友开始,继续0...m-1报数....这样下去....直到剩下最后一个小朋友,可以不用表演,并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。
 * 请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
 */

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Q45 {
    public int LastRemaining_Solution(int n, int m) {
        //创建一个环形链表
        ListNode firstNode = null;
        ListNode tmp = null;
        for (int i = 0; i < n; i++) {
            //处理首节点
            if (i == 0) {
                ListNode ln = new ListNode(i);
                firstNode = ln;
                tmp = ln;
            }
            //处理末节点
            else if (i == n - 1) {
                ListNode ln = new ListNode(i);
                tmp.next = ln;
                tmp = ln;
                tmp.next = firstNode;
            } else {
                ListNode ln = new ListNode(i);
                tmp.next = ln;
                tmp = ln;
            }
        }

        tmp = firstNode;
        while (n != 1) {
            for (int i = 0; i < m-2; i++) {
                tmp = tmp.next;
            }
            System.out.println("出列的小孩是"+tmp.next.val);
            tmp.next = tmp.next.next;
            tmp = tmp.next;
            n--;
        }
        System.out.println("存活的小孩是"+tmp.val);

//        int j = 0;
//        while (j < 10) {
//            System.out.println(firstNode.val);
//            firstNode = firstNode.next;
//            j++;
//        }


        return 0;
    }
}

class test {
    public static void main(String[] args) {
        ;
        Q45 q45 = new Q45();
        q45.LastRemaining_Solution(7, 4);
    }
}
