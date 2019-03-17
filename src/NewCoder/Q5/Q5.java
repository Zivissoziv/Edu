package NewCoder.Q5;

import java.util.Stack;

/**
 * Created by Ziv on 2019/1/26.
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */
public class Q5 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            throw new RuntimeException("Queue is empty!");
        }
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

}

class Test{
    public static void main(String[] args) {
        Q5 q5 = new Q5();
        q5.push(6);
        q5.push(7);
        System.out.println(q5.pop());
    }
}
