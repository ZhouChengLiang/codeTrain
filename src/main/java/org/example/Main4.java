package org.example;

import java.util.Arrays;

public class Main4 {
    public static int[] merge(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        // 创建一个新数组，用于存储合并后的结果
        int[] merged = new int[m + n];
        int i = 0, j = 0, k = 0;

        // 同时遍历两个数组，比较元素大小，将较小元素放入新数组
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                merged[k++] = nums1[i++];
            } else {
                merged[k++] = nums2[j++];
            }
        }
        System.out.println("i = " + i + ", j = " + j+", k = " + k);
        System.out.println(Arrays.toString(merged));
        // 将 nums1 中剩余元素添加到新数组
        while (i < m) {
            merged[k++] = nums1[i++];
        }

        // 将 nums2 中剩余元素添加到新数组
        while (j < n) {
            merged[k++] = nums2[j++];
        }

        return merged;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3, 5};
        int[] nums2 = {2, 4, 6};
        int[] merged = merge(nums1, nums2);
        // 输出合并后的数组
        for (int num : merged) {
            System.out.print(num + " ");
        }
    }
}
