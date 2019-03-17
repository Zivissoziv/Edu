package NewCoder.Q20;

import java.util.Stack;

/**
 * Created by Ziv on 2019/2/10.
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 */


public class Q20 {

    Stack<Integer> data = new Stack<Integer>();
    Stack<Integer> min = new Stack<Integer>();
    int tmp = 0;

    public void push(int node) {
        if (min.isEmpty()) {
            min.push(node);
            tmp = node;
        } else {
            if (min.peek() > node) {
                min.push(node);
                tmp = node;
            } else {
                min.push(tmp);
            }
        }
        data.push(node);
    }

    public void pop() {
        data.pop();
        min.pop();
    }

    public int top() {
        return data.peek();
    }

    public int min() {
        return min.peek();
    }

}
