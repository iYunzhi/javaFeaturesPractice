package LeetCode.LeetCode46;

import LeetCode.LeetCode98.TreeNode;

import java.awt.geom.FlatteningPathIterator;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class Solution {

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(20);

    }

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> path = new ArrayList<>();

        boolean[] used = new boolean[nums.length];

        backtrack(nums,path,used);

        return res;
    }

    private void backtrack(int[] nums, List<Integer> path, boolean[] used) {
        if (path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]){
                continue;
            }

            path.add(nums[i]);
            used[i] = true;

            backtrack(nums,path,used);

            path.remove(path.size() -1);
            used[i] = false;
        }
    }
}
