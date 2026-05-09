package LeetCode.LeetCode108;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        int[] array = {-4,-1,0,3,10};

        System.out.println(Arrays.toString(sortedSquares(array)));
    }

    public static int[] sortedSquares(int[] nums) {
        int k = nums.length - 1;
        int i = 0;
        int j = nums.length -1;

        int[] result = new int[nums.length];
        while (i <= j){
            if (nums[i] * nums[i] > nums[j] * nums[j]) {
                result[k--] = nums[i] * nums[i];
                i++;
            } else {
                result[k--] = nums[j] * nums[j];
                j--;
            }
        }
        return result;
    }
}
