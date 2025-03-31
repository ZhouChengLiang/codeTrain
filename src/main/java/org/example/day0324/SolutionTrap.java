package org.example.day0324;

import java.util.Stack;

/**
 * @author zhouchengliang
 *
 * 接雨水
 * leetcode 42
 */
public class SolutionTrap {

    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int ans = 0;
        Stack<Rect> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            int accumulatedWidth = 0;
            while (!stack.isEmpty() && stack.peek().height <= height[i]) {
                int bottom = stack.peek().height;
                accumulatedWidth += stack.peek().width;
                stack.pop();
                if(stack.isEmpty()){
                    continue;
                }
                // 以bottom为底的横块水，最高可以到up(左右两侧高度的min)
                int up = Math.min(height[i], stack.peek().height);
                ans += accumulatedWidth *(up - bottom);
            }
            stack.push(new Rect(accumulatedWidth+1,height[i]));
        }
        return ans;
    }

    /**
     * 前缀 后缀和
     * @param height
     * @return
     */
    public int trapV2(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int ans = 0;
        int n = height.length;
        int[] preMax = new int[n];
        int[] sufMax = new int[n];
        preMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            preMax[i] = Math.max(preMax[i-1], height[i]);
        }
        sufMax[n-1] = height[n-1];
        for (int i = n-2; i >= 0; i--) {
            sufMax[i] = Math.max(sufMax[i+1], height[i]);
        }
        for (int i = 1; i < n-1; i++) {
            int up = Math.min(preMax[i], sufMax[i+1]);
            int bottom = height[i+1];
            if(up > bottom){
                ans += (up - bottom);
            }
        }
        return ans;
    }
}
