package FourSum;

import java.util.HashMap;

public class Solution {

    public static void main(String[] args) {

         //nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
        int[] nums1 = {1,2};
        int[] nums2 = {-2,-1};
        int[] nums3 = {-1,2};
        int[] nums4 = {0,2};

        System.out.println(fourSumCount(nums1, nums2, nums3, nums4));


    }

    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int count = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int k : nums1) {
            for (int i : nums2) {
                int sum = k+i;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        for (int j : nums3) {
            for (int i : nums4) {
                int cd = -(j + i);
                if (map.containsKey(cd)) {
//                    count = count + map.get(cd);
                    count += map.get(cd);
                }
            }
        }

        return count;
    }
}
