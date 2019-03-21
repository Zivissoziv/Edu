package Practise;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Ziv on 2019/3/21.
 * 数据流中的中位数
 */
public class Practise11 {
    int count = 0;
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(15,new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });

    void insert(Integer num) {
        if (count % 2 == 0) {
            maxHeap.offer(num);
            int tmp = maxHeap.poll();
            minHeap.offer(tmp);
        } else {
            minHeap.offer(num);
            int tmp = minHeap.poll();
            maxHeap.offer(tmp);
        }
        count++;
    }

    Double getMedian() {
        if (count %2 == 0) {
            return new Double((minHeap.peek() + maxHeap.peek())) / 2;
        } else {
            return new Double(minHeap.peek());
        }
    }

    public static void main(String[] args) {
        Practise11 p11 = new Practise11();
        p11.insert(5);
        p11.insert(10);
        p11.insert(2);
        System.out.println(p11.getMedian());
    }
}
