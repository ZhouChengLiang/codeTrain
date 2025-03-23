package org.example;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] strArr1 = in.nextLine().split(" ");
        int row = Integer.valueOf(strArr1[0]);
        int column = Integer.valueOf(strArr1[1]);
        int[] indexAll = new int[row * column];
        int k = 0;
        for(int i = 0; i < row; i++){
            String[] strArr = in.nextLine().split(" ");
            for(int j = 0; j < column; j++){
                indexAll[k++] = Integer.valueOf(strArr[j]);
            }
        }
        int middle = indexAll.length / 2;
        if(indexAll.length % 2 != 0 && indexAll[middle] == 1){
            System.out.println(1);
        } else {
            System.out.println(2);
        }
    }
}
