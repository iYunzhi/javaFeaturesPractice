package LeetCode.LeetCode78;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> path = new ArrayList<>();

        backtrack(nums,path,0);

        return res;
    }

    public void backtrack(int[] nums, List<Integer> path, int startIdx){
        res.add(new ArrayList<>(path));

        for (int i = startIdx; i < nums.length ; i++){
            path.add(nums[i]);

            backtrack(nums,path,i + 1);

            path.remove(path.size() -1);
        }
    }
}
