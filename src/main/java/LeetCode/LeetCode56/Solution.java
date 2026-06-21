package LeetCode.LeetCode56;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[][] test = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        Solution solution = new Solution();
        System.out.println(Arrays.deepToString(solution.merge(test)));
    }


    public int[][] merge(int[][] intervals) {
        List<int[]> ans = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        for (int[] v : intervals) {
            int n = ans.size();
            if (!ans.isEmpty() && v[0] <= ans.get(n-1)[1]){
                ans.get(n-1)[1] = Math.max(ans.get(n-1)[1],v[1]);
            } else {
                ans.add(v);
            }
        }

        return ans.toArray(new int[0][]);
    }
}
