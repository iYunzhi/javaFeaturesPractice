package LeetCode.LeetCode53;

import static java.lang.Integer.MIN_VALUE;

public class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = MIN_VALUE;
        int curSum = 0;
        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            maxSum = Math.max(maxSum, curSum);
            if (curSum < 0) {
                curSum = 0;
            }
        }
        return maxSum;
    }
}
