package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 子集
 *   输入 nums = [1,2,3]
 *   输出 [[],[1],[2],[3],[1,2],[1,3],[2,3],[1,2,3]]
 * @author zhouchengliang
 */
public class Main6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] partArr = in.nextLine().split(" ");
        List<String> temp = new ArrayList<>();
        List<List<String>> result = new ArrayList<>();
        recur(partArr, 0, result,temp);
        System.out.println(result);
    }

    public static void recur(String[] strArr,int i,List<List<String>> result,List<String> temp){
        if(i == strArr.length){
            result.add(new ArrayList<>(temp));
            return;
        }
        recur(strArr,i+1,result,temp);
        temp.add(strArr[i]);
        recur(strArr,i+1,result,temp);
        temp.remove(temp.size()-1);
    }
}
