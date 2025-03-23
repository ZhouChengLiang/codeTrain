package org.example.day0320;

import java.util.Stack;

/**
 * @author zhouchengliang
 * leetcode 155
 * 最小栈
 */
public class SolutionMinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public SolutionMinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty()) {
            minStack.push(val);
        }else {
            minStack.push(Math.min(minStack.peek(),val));
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
