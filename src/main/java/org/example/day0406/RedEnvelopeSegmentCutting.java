package org.example.day0406;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RedEnvelopeSegmentCutting {

    /**
     * 线段切割法实现红包分配
     * @param totalAmount 红包总金额（单位：分）
     * @param totalCount 红包总个数
     * @return 每个红包的金额列表（单位：分）
     */
    public static List<Integer> divideRedEnvelopeBySegmentCutting(int totalAmount, int totalCount) {
        List<Integer> amountList = new ArrayList<>();
        Random random = new Random();

        if (totalCount == 1) {
            amountList.add(totalAmount);
            return amountList;
        }

        // 随机生成切割点
        int[] cuts = new int[totalCount - 1];
        for (int i = 0; i < totalCount - 1; i++) {
            cuts[i] = random.nextInt(totalAmount - 1) + 1;
        }
        // 对切割点进行排序
        Arrays.sort(cuts);

        int prev = 0;
        for (int i = 0; i < totalCount - 1; i++) {
            int amount = cuts[i] - prev;
            amountList.add(amount);
            prev = cuts[i];
        }
        // 最后一个红包的金额
        amountList.add(totalAmount - prev);

        return amountList;
    }

    public static void main(String[] args) {
        int totalAmount = 1000; // 总金额 10 元，单位：分
        int totalCount = 10;    // 红包个数
        List<Integer> result = divideRedEnvelopeBySegmentCutting(totalAmount, totalCount);
        for (int amount : result) {
            System.out.println("红包金额：" + amount + " 分");
        }
    }
}