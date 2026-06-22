package LeetCode.LeetCode1470;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        int[] a = {2,5,1,3,4,7};
        System.out.println(Arrays.toString(shuffle(a, 3)));
    }
    public static int[] shuffle(int[] nums, int n) {
        int[] res = new int[2*n];
        int k=0;
        for(int i=0;i<n;i++){
            res[k]=nums[i];
            k+=2;
        }
        int l=1;
        for(int i=n;i<2*n;i++){
            res[l]=nums[i];
            l+=2;
        }
        return res;
    }
}
