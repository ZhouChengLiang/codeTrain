package org.example;

import java.util.Arrays;
import java.util.Scanner;

//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str1 = in.nextLine();
        int[] intArray1 = transIntArr(str1);
        String str2 = in.nextLine();
        int[] intArray2 = transIntArr(str2);
        Arrays.sort(intArray1);
        Arrays.sort(intArray2);
        int number = Integer.parseInt(in.nextLine());
        int minNumber = getResult(intArray1, intArray2, number);
        System.out.println(minNumber);
    }

    public static int[] transIntArr(String str1){
        String[] strArray1 = str1.split(" ");
        int[] arr = new int[strArray1.length];
        for (int i = 0; i < strArray1.length; i++) {
            arr[i] = Integer.parseInt(strArray1[i]);
        }
        return arr;
    }

    // 12
    // 12
    // 2 3 3 4
    public static int getResult(int[] intArray1,int[] intArray2,int number){
        int result = 0;
        int k = 0;
        int[] mergeResult = new int[intArray1.length * intArray2.length];
        for (int i = 0; i < intArray1.length; i++) {
            for (int j = 0; j < intArray2.length; j++) {
                mergeResult[k++] = intArray1[i] + intArray2[j];
            }
        }
        Arrays.sort(mergeResult);
        for (int i = 0; i < number; i++) {
            result += mergeResult[i];
        }
        return result;
    }
}