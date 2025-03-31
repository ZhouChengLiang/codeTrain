package org.example.day0323;

import java.util.Stack;

/**
 * @author zhouchengliang
 *
 * 给你一个字符串数组 tokens ，表示一个根据 逆波兰表示法 表示的算术表达式。
 * 请你计算该表达式。返回一个表示表达式值的整数。
 *
 * 后缀表达式
 */
public class SolutionEvalRPN {

    Stack<Integer> stack = new Stack<>();

    public int evalRPN(String[] tokens) {
        for (String token : tokens) {
            if ("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token)) {
                int y = stack.peek();
                stack.pop();
                int x = stack.peek();
                stack.pop();
                int z = calc(x,y,token);
                stack.push(z);
            }else{
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.peek();
    }

    private int calc(int x, int y, String token) {
        switch (token) {
            case "+":
                return x + y;
            case "-":
               return x - y;
            case "*":
                 return x * y;
            case "/":
               return x / y;
        }
        return 0;
    }
}
