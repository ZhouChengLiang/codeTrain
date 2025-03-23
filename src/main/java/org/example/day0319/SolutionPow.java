package org.example.day0319;

/**
 * Pow(x,n)
 * @author zhouchengliang
 */
public class SolutionPow {
    public double myPow(double x, int n) {
        return Math.pow(x, n);
    }

    public double myPow2(double x, int n) {
       if (n == 0) {
           return 1;
       }
       if(n == -(1l<<31)){
           return 1.0/(myPow2(x, -(n+1))*x);
       }
       if (n < 0) {
           return 1.0/myPow2(x, -n);
       }
       double res = myPow2(x, n / 2);
       double ans = res * res;
       if (n % 2 == 1) {
           ans = ans * x;
       }
       return ans;
    }

    public static void main(String[] args) {
        // 计算 int 类型的最大值
        int maxValue = (1 << 31) - 1;
        // 计算 int 类型的最小值
        int minValue = 1 << 31;
        // int 类型的最大值: 2147483647
        // int 类型的最小值: -2147483648
        System.out.println("int 类型的最大值: " + maxValue);
        System.out.println("int 类型的最小值: " + minValue);
    }
}
