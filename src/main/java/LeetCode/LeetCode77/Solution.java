package LeetCode.LeetCode77;

import java.util.ArrayList;
import java.util.List;

public class Solution {



    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> path = new ArrayList<>();
        backtrack(n,k,1,path);

        return res;
    }

    private void backtrack(int n, int k, int startIdx, List<Integer> path) {
        if(path.size() == k){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIdx ; i <= n; i++){
            path.add(i);

            backtrack(n,k,i+1,path);

            path.remove(path.size() -1);
        }
    }
}
