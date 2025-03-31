package org.example.day0325;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhouchengliang
 * 两数之和
 * leetcode 1
 */
public class SolutionTwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i],i);
        }
        return new int[]{};
    }
}
