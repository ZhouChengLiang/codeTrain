package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 全排列
 * @author zhouchengliang
 */
public class Main8 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] partArr = in.nextLine().split(" ");
        List<String> temp = new ArrayList<>();
        List<List<String>> result = new ArrayList<>();
        boolean[] used = new boolean[partArr.length];
        recur(partArr, 0, result,temp,used);
        System.out.println(result);
    }

    public static void recur(String[] strArr,int pos,List<List<String>> result,List<String> temp,boolean[] used){
        if(pos == strArr.length){
            result.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0;i<strArr.length ;i++ ){
            if(!used[i]){
                temp.add(strArr[i]);
                used[i] = true;
                recur(strArr,pos+1,result,temp,used);
                used[i] = false;
                temp.remove(temp.size()-1);
            }
        }
    }
}
