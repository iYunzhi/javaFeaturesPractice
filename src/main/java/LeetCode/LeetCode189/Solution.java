package LeetCode.LeetCode189;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1,2,3,4,5,6,7};
        solution.rotate(nums,3);
        System.out.println(Arrays.toString(nums));


    }

    public void rotate(int[] nums, int k) {
        Deque<Integer> queue = new LinkedList<>();

        for (int num : nums) {
            queue.offer(num);
        }

        while (k > 0){
            Integer i = queue.pollLast();
            queue.offerFirst(i);
            k--;
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = queue.pollFirst();
        }

    }
}
