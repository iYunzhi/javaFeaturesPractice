package LeetCode.LeetCode121;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(new int[]{2,1,4}));
    }


    public int maxProfit(int[] prices) {
//        int ans = 0;
//
//        for (int i = 0; i < prices.length; i++) {
//            int curPrice = prices[i];
//            int profit = 0;
//            for (int j = i; j < prices.length; j++) {
//                if (prices [j] - curPrice > profit && prices[j] > curPrice) {
//                    profit = prices[j] - curPrice;
//                }
//            }
//            if (profit > ans){
//                ans = profit;
//            }
//        }
//
//        return ans;
        if (prices == null || prices.length == 0){
            return 0;
        }
        int[] copied = Arrays.copyOf(prices, prices.length);
        Arrays.sort(copied);
        int minVal = copied[copied.length - 1];
        int maxProfit = 0;

        for (int p : prices) {
            if (p < minVal) {
                minVal = p;
            } else if (p - minVal > maxProfit){
                maxProfit = p - minVal;
            }
        }
        return maxProfit;
    }
}
