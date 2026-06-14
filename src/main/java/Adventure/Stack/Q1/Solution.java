package Adventure.Stack.Q1;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.buildArray(new int[]{1, 3}, 3));
    }

    public List<String> buildArray(int[] target, int n) {
        List<String> res = new ArrayList<>();
        int j = 0;

        for (int i = 1; i <= n && j < target.length ; i++) {
            res.add("Push");
            if (i == target[j]) {
                j++;
            } else {
                res.add("Pop");
            }
        }

        return res;
    }
}
