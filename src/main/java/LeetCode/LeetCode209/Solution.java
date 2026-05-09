package LeetCode.LeetCode209;

import java.awt.image.renderable.RenderableImage;

public class Solution {
    public static void main(String[] args) {

    }

    public static int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int left = 0;
        int minLen = Integer.MAX_VALUE;

        for (int right = 0;right < nums.length;right++){
            sum = sum + nums[right];
            while (sum >= target){
                minLen = Math.min(minLen,right - left + 1);
                sum = sum - nums[left];
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
