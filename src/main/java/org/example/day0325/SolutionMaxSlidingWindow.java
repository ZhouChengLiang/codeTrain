package org.example.day0325;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhouchengliang
 * leetcode 239 滑动窗口最大值
 */
public class SolutionMaxSlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        List<Integer> list = new ArrayList<>();
        Deque<Integer> q = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            // 删除出界的选项
            while (!q.isEmpty() && q.getFirst() <= i - k) {
                q.removeFirst();
            }
            // 插入新选项i，维护单调性 (值递减)
            while (!q.isEmpty() && nums[q.getLast()] <= nums[i]) {
                q.removeLast();
            }
            q.addLast(i);
            // 取队头更新答案
            if (i >= k - 1) {
                list.add(nums[q.getFirst()]);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
