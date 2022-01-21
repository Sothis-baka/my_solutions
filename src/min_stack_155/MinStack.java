package min_stack_155;

import java.util.Stack;

/*
    Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

    Implement the MinStack class:

    MinStack() initializes the stack object.
    void push(int val) pushes the element val onto the stack.
    void pop() removes the element on the top of the stack.
    int top() gets the top element of the stack.
    int getMin() retrieves the minimum element in the stack.
 */
public class MinStack {
    private static class Node{
        int val;
        Node next;
        int min;

        Node(int val, Node next){
            this.val = val;
            this.next = next;
            this.min = next == null ? val : Math.min(val, next.min);
        }
    }

    Node head;

    public MinStack() {
        this.head = null;
    }

    public void push(int val) {
        this.head = new Node(val, this.head);
    }

    public void pop() {
        if(this.head != null){
            this.head = this.head.next;
        }
    }

    public int top() {
        return this.head.val;
    }

    public int getMin() {
        return this.head.min;
    }
}
