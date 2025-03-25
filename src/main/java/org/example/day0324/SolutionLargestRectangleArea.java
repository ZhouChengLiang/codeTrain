package org.example.day0324;

import java.util.Stack;

/**
 * @author zhouchengliang
 * 柱状图中最大的矩形
 * leetcode 84
 */
public class SolutionLargestRectangleArea {

    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int[] tmp = new int[heights.length + 1];
        System.arraycopy(heights, 0, tmp, 1, heights.length);
        tmp[tmp.length-1] = 0;
        Stack<Rect> stack = new Stack<>();
        int ans = 0;
        for (int i = 0; i < heights.length; i++) {
           int accumulatedWidth = 0;
           // 栈顶(之前)高度 >= 当前高度，单调性破坏，确定了栈顶高度的扩展范围，需要删除栈顶
            while (!stack.isEmpty() && stack.peek().height >= heights[i]) {
                accumulatedWidth += stack.peek().width;
                ans = Math.max(ans, stack.peek().height * accumulatedWidth);
                stack.pop();
            }
            stack.push(new Rect(accumulatedWidth+1,heights[i]));
        }
        return ans;
    }
}

class Rect {
    int width;
    int height;

    public Rect() {}
    public Rect(int width, int height) {
        this.width = width;
        this.height = height;
    }
}

