package LeetCode.LeetCode128;

import java.util.HashSet;

public class Solution {

    public static void main(String[] args) {
        int[] nums = {0};

        System.out.println(longestConsecutive(nums));
    }

    //给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
    //请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
//    public static int longestConsecutive(int[] nums) {
//        HashMap<Integer,Integer> map = new HashMap<>();
//
//        for (int num : nums) {
//            map.put(num,map.getOrDefault(num,0)+1);
//        }
//
//        int max = Integer.MIN_VALUE;
//        int min = Integer.MAX_VALUE;
//        for (int num : nums) {
//            if(num > max) max = num;
//        }
//        for (int num : nums) {
//            if(num < min) min = num;
//        }
//
//        int maxLen = 0;
//        HashSet<Integer> set = new HashSet<>();
//
//        for (int i = min; i <= max; i++) {
//            if(map.containsKey(i)){
//                maxLen++;
//                set.add(maxLen);
//                continue;
//            }
//            maxLen = 0;
//        }
//        if (set.isEmpty()) return maxLen;
//
//        return Collections.max(set);
//    }

    public static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {return 0;}
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int maxLen = 0;

        for (int num : set) {
            if(!set.contains(num-1)){
                int currentNum = num;
                int longestNumLen = 1;
                while (set.contains(currentNum+1)) {
                    currentNum++;
                    longestNumLen++;
                }
                maxLen = Math.max(longestNumLen, maxLen);
            }
        }
        return maxLen;
    }
}
