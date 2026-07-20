package LeetCode.LeetCode560;

import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.subArraySum(new int[]{1, 2, 3}, 3));
    }
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        for (int i = 0 ; i < nums.length; i++){
            int sum = 0;
            for (int j = i; j < nums.length; j++){
                sum += nums[j];
                if (sum == k){
                    res++;
                }
            }
        }
        return res;
    }

    public int subArraySum(int[] nums, int k){
        HashMap<Integer,Integer> map = new HashMap<>();
        int res = 0;  int sum = 0;
        map.put(0,1);

        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k)){
                res += map.get(sum - k);
            }

            map.put(sum,map.getOrDefault(sum,0) + 1);
        }

        return res;
    }
}
