package org.example.day0323;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author zhouchengliang
 *
 * 基本计算器 II
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 * 整数除法仅保留整数部分。
 * 你可以假设给定的表达式总是有效的。所有中间结果将在 [-231, 231 - 1] 的范围内。
 * 注意：不允许使用任何将字符串作为数学表达式计算的内置函数，比如 eval() 。
 * 中缀转化成后缀的方式
 *
 * suffix
 */
public class SolutionCalculate {
    Stack<Character> ops = new Stack<>();
    Stack<Integer> stack = new Stack<>();
    public int calculate(String s) {
        s+= " ";
        String number = "";
        List<String> tokens = new ArrayList<>();
        boolean needsZero = true;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= '0' && ch <= '9') {
                number += ch;
                needsZero = false;
                continue;
            }else{
                if(!number.isEmpty()){
                    tokens.add(number);
                    number = "";
                }
            }
            if (ch == ' '){
                continue;
            }
            if(ch =='('){
                ops.push(ch);
                needsZero = true;
                continue;
            }
            if(ch == ')'){
                while(!ops.peek().equals('(')){
                    tokens.add(ops.peek().toString());
                    ops.pop();
                }
                ops.pop();
                needsZero = false;
                continue;
            }
            if((ch == '+' || ch == '-') && needsZero){
                tokens.add("0");
            }
            int currRank = getRank(ch);
            while(!ops.isEmpty() && getRank(ops.peek())>=currRank){
                tokens.add(ops.peek().toString());
                ops.pop();
            }
            ops.push(ch);
            needsZero = true;
        }
        while(!ops.isEmpty()){
            tokens.add(ops.peek().toString());
            ops.pop();
        }
        return evalRPN(tokens.toArray(new String[0]));
    }

    int getRank(char ch){
        if(ch == '*' || ch == '/'){
            return 2;
        }
        if(ch == '+' || ch == '-'){
            return 1;
        }
        return 0;
    }

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

    public static void main(String[] args) {
        SolutionCalculate sol = new SolutionCalculate();
        System.out.println(sol.calculate("2048"));
    }
}
