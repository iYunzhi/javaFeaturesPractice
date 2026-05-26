package LeetCode.LeetCode1;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {

        Solution solution = new Solution();

        System.out.println(Arrays.toString(solution.twoSum(new int[]{3,4,4}, 6)));
    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
