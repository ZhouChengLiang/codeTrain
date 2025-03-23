package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 * S = (A)B
 * n = k-1 n-k
 * @author zhouchengliang
 */
public class SolutionGenerateParenthesis {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if(n==0){
            result.add("");
            return result;
        }
        for(int i=1;i<=n;i++){
            List<String> leftParenthesis = generateParenthesis(i-1);
            List<String> rightParenthesis = generateParenthesis(n-i);
            for(int j=0;j<leftParenthesis.size();j++){
                for(int k=0;k<rightParenthesis.size();k++){
                    result.add("("+leftParenthesis.get(j)+")"+rightParenthesis.get(k));
                }
            }
        }
        return result;
    }



    public static void main(String[] args) {
        SolutionGenerateParenthesis solution = new SolutionGenerateParenthesis();
        System.out.println(solution.generateParenthesis(3));
    }
}
