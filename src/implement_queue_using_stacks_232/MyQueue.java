package implement_queue_using_stacks_232;

import java.util.Stack;

/*
    Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).

    Implement the MyQueue class:

    void push(int x) Pushes element x to the back of the queue.
    int pop() Removes the element from the front of the queue and returns it.
    int peek() Returns the element at the front of the queue.
    boolean empty() Returns true if the queue is empty, false otherwise.
    Notes:

    You must use only standard operations of a stack, which means only push to top, peek/pop from top, size, and is empty operations are valid.
    Depending on your language, the stack may not be supported natively. You may simulate a stack using a list or deque (double-ended queue) as long as you use only a stack's standard operations.
 */
public class MyQueue {
    Stack<Integer> stack;
    Stack<Integer> stackR;

    public MyQueue() {
         this.stack = new Stack<>();
         this.stackR = new Stack<>();
    }

    public void push(int x) {
        this.stack.push(x);
    }

    public int pop() {
        peek();
        return stackR.pop();
    }

    public int peek() {
        if(stackR.isEmpty()){
            while(!stack.isEmpty()){
                stackR.push(stack.pop());
            }
        }

        return stackR.peek();
    }

    public boolean empty() {
        return stack.isEmpty() && stackR.isEmpty();
    }
}
