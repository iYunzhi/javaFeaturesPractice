package LeetCode.LeetCode26;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        int p = 1;
        int p1 = 2;
        while (p1 <= nums.length -1){
            if (nums[p1-1] != nums[p1]){
                nums[p]=nums[p1];
                p++;
            }
            p1++;
        }
        return p;
    }
}
