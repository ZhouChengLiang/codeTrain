package org.example.day0406;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RedEnvelopeAlgorithm {

    /**
     * 二倍均值法实现红包分配
     * @param totalAmount 红包总金额（单位：分）
     * @param totalCount 红包总个数
     * @return 每个红包的金额列表（单位：分）
     */
    public static List<Integer> divideRedEnvelope(int totalAmount, int totalCount) {
        List<Integer> amountList = new ArrayList<>();
        Random random = new Random();

        int remainingAmount = totalAmount;
        int remainingCount = totalCount;

        for (int i = 0; i < totalCount - 1; i++) {
            // 计算当前红包金额的最大值
            int max = remainingAmount / remainingCount * 2;
            // 随机生成当前红包的金额
            int amount = random.nextInt(max) + 1;
            amountList.add(amount);
            // 更新剩余金额和剩余个数
            remainingAmount -= amount;
            remainingCount--;
        }
        // 最后一个红包直接将剩余金额放入
        amountList.add(remainingAmount);

        return amountList;
    }

    public static void main(String[] args) {
        int totalAmount = 1000; // 总金额 10 元，单位：分
        int totalCount = 10;    // 红包个数
        List<Integer> result = divideRedEnvelope(totalAmount, totalCount);
        for (int amount : result) {
            System.out.println("红包金额：" + amount + " 分");
        }
    }
}