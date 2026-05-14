package LeetCode.LeetCode15;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }


    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue;

            int tar = -nums[i];
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                if( l != i + 1 && nums[l] == nums[l-1]) {
                    l++;
                    continue;
                }
                int sum = nums[l] + nums[r];
                if (sum < tar){
                    l++;
                } else if (sum > tar){
                    r--;
                } else {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                }
            }
        }
        return res;
    }
}
