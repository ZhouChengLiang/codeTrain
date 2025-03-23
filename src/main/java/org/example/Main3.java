package org.example;

public class Main3 {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,4,5,6};
        System.out.println(bsearch(a,a.length,4));
        System.out.println(bsearch2(a,a.length,4));

    }

    /** 查找第一个值等于给定值的元素
     * 二分查找法
     * @param a
     * @param n
     * @param value
     * @return
     */
    public static int bsearch(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid =  low + ((high - low) >> 1);
            if (a[mid] > value) {
                high = mid - 1;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                if ((mid == 0) || (a[mid - 1] != value)) return mid;
                else high = mid - 1;
            }
        }
        return -1;
    }

    /** 查找最后一个值等于给定值的元素
     * 二分查找法
     * @param a
     * @param n
     * @param value
     * @return
     */
    public static int bsearch2(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid =  low + ((high - low) >> 1);
            if (a[mid] > value) {
                high = mid - 1;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                if ((mid == n-1) || (a[mid + 1] != value)) return mid;
                else low = mid + 1;
            }
        }
        return -1;
    }

    /** 查找第一个大于等于给定值的元素
     * 二分查找法
     * @param a
     * @param n
     * @param value
     * @return
     */
    public static int bsearch3(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid =  low + ((high - low) >> 1);
            if (a[mid] >= value) {
                if((mid == 0) || (a[mid - 1] < value)){
                   return mid;
                }else {
                    high = mid - 1;
                }
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    /** 查找最后一个小于等于给定值的元素
     * 二分查找法
     * @param a
     * @param n
     * @param value
     * @return
     */
    public static int bsearch4(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid =  low + ((high - low) >> 1);
            if (a[mid] > value) {
                high = mid - 1;
            } else {
                if((mid == n-1)||(a[mid + 1] > value)){
                    return mid;
                }else{
                    low = mid + 1;
                }
            }
        }
        return -1;
    }
}
