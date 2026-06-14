package LeetCode.LeetCode739;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.dailyTemperaturesNeo(new int[]{30,60,90})));
    }

    /*
        超出时间限制
     */
    public int[] dailyTemperatures(int[] temperatures) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < temperatures.length; i++) {
            int curT = temperatures[i];
            int val = 1;
            for (int j = i + 1; j < temperatures.length; j++) {
                if (temperatures[j] <= curT){
                    val++;
                }
                if (temperatures[j] > curT){
                    break;
                }
            }
            if (i + val == temperatures.length){
                res.add(0);
                continue;
            }
            res.add(val);
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] dailyTemperaturesNeo(int[] temperatures){
        int n = temperatures.length;
        int[] res = new int[n];

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                int topIdx = stack.pop();
                res[topIdx] = i - topIdx;
            }

            stack.push(i);
        }

        return res;
    }
}
