package LeetCode.LeetCode485;

public class Solution {
    public static void main(String[] args) {
       int[] nums = {1,0,1,1,0,1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int result =0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i] == 1){
                count++;
                if (count > result){
                    result=count;
                }
            } else{
                count = 0;
            }
        }
        return result;
    }
}
