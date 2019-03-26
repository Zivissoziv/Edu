package DesignMode.Iterator;

/**
 * Created by Ziv on 2019/3/26.
 * 自己实现一个LinkedList
 */

class Node {
    Object val;
    Node next;

    public Node(Object o) {
        this.val = o;
    }
}

public class myLinkedList implements myCollections {
    Node head = null;
    Node tail = null;
    int size = 0;

    @Override
    public void add(Object o) {
        Node n = new Node(o);
        if (head == null) {
            head = n;
            tail = n;
        } else {
            tail.next = n;
            tail = tail.next;
        }
        size++;
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public myIteractor iteractor() {
        return new myLinkedIteractor();
    }

    private class myLinkedIteractor implements myIteractor {
        private Node currentNode = head;
        private int nextIndex = 0;

        @Override
        public boolean hasNext() {
            return nextIndex != size;
        }

        @Override
        public Object next() {
            Object o = currentNode.val;
            currentNode = currentNode.next;
            nextIndex++;
            return o;
        }
    }
}
