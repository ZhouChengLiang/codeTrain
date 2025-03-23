package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int total = Integer.parseInt(in.nextLine());
        String[] partArr = in.nextLine().split(" ");
        int totalWeight = 0;
        int[] arr = new int[total];
        for (int i = 0; i < partArr.length; i++) {
            arr[i] = Integer.parseInt(partArr[i]);
            totalWeight += arr[i];
        }
        if(totalWeight%2 !=0){
            System.out.println(-1);
        }else{
            int halfWeight = totalWeight / 2 ;
            Arrays.sort(arr);
            int remain = halfWeight - arr[total-1];
            if(remain ==0){
                System.out.println(1);
            }else{
                System.out.println(2);
            }
        }
    }
}
