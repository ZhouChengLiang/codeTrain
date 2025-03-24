package org.example.day0320;

import java.util.Stack;

/**
 * 有效的括号
 *  验证括号的有效性
 *  ((())) ([])
 * leetcode 20题
 * @author zhouchengliang
 */
public class SolutionIsValid {

    public boolean isValid(String s) {
        char[] charArr = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < charArr.length; i++) {
            char c = charArr[i];
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if(stack.isEmpty()){
                    return false;
                }
                if(c == ')' && stack.peek() != '('){
                    return false;
                }
                if(c == ']' && stack.peek() != '['){
                    return false;
                }
                if(c == '}' && stack.peek() != '{'){
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
