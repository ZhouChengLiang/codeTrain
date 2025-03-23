package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 组合
 *
 * 输入： n = 4 , k = 2
 * 输出：
 *  [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4]
 *  ]
 * @author zhouchengliang
 */
public class Main7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] partArr = in.nextLine().split(" ");
        int n = Integer.parseInt(partArr[0]);
        int k = Integer.parseInt(partArr[1]);
        List<String> temp = new ArrayList<>();
        List<List<String>> result = new ArrayList<>();
        recur(n,k,1,result,temp);
        System.out.println(result);
    }
    public static void recur(int n,int k,int i,List<List<String>> result,List<String> temp){
        if(temp.size() > k || temp.size() + (n-i+1) < k){
            return;
        }
        if(i == n+1){
            result.add(new ArrayList<>(temp));
            return;
        }
        recur(n,k,i+1,result,temp);
        temp.add(String.valueOf(i));
        recur(n,k,i+1,result,temp);
        temp.remove(temp.size()-1);
    }
}
