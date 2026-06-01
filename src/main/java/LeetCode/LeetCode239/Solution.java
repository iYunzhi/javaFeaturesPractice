package LeetCode.LeetCode239;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }

    /**
     * 超出时间限制
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int l = 0; int r = 0;
        List<Integer> result = new ArrayList<>();
        while (r < nums.length){
            if (r - l + 1 == k){
                int curMax = nums[l];
                for (int i = 1; i < k; i++){
                    if (curMax < nums[l + i]){
                        curMax = nums[l + i];
                    }
                }
                result.add(curMax);
                l++;
            }
            r++;
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    /*
      ===== 可行方法：单调队列（Monotonic Deque）=====

      你的方法每滑动一次窗口都要遍历 k 个元素找最大值，时间复杂度 O(n*k)，大数据集会超时。
      单调队列可以在 O(n) 内解决问题。核心思路：

      1. 维护一个"双端队列"（Deque），里面存的是数组下标。
         队列满足：从队头到队尾，对应的 nums 值是 **递减** 的（单调递减队列）。
         也就是说，队头永远是当前窗口的最大值的下标。

      2. 每次加入一个新元素 nums[r] 时：
         - 从队尾开始，把所有比 nums[r] 小的元素全部弹出（因为它们不可能再成为最大值了，
           r 比它们晚离开窗口，而且值还更大）。
         - 然后把 r 加入队尾。

      3. 每次检查队头：
         - 如果队头的下标已经滑出了窗口左边界（下标 < l），就从队头弹出。
         - 此时队头就是当前窗口的最大值下标。

      4. 当窗口大小达到 k 时，取队头对应的值加入结果集。

      为什么是 O(n)？——每个元素最多被加入队列一次、弹出队列一次，所以总操作数是 2n。

      ===== 图解示例 nums=[1,3,-1,-3,5,3,6,7], k=3 =====

      窗口 [1,3,-1]  -> 队列存下标 [1,2]    (值 [3,-1]) -> max=3
      窗口 [3,-1,-3] -> 队列存下标 [1,2,3]  (值 [3,-1,-3]) -> max=3
      窗口 [-1,-3,5] -> 弹出 1,2,3，加入 4 -> 队列 [4] (值 [5]) -> max=5
      窗口 [-3,5,3]  -> 队列 [4,5] (值 [5,3]) -> max=5
      窗口 [5,3,6]   -> 弹出 4,5，加入 6 -> 队列 [6] (值 [6]) -> max=6
      窗口 [3,6,7]   -> 弹出 6，加入 7 -> 队列 [7] (值 [7]) -> max=7

      ===== 代码实现 =====

      class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        // 1. 提前分配好固定大小的数组，极其轻量
        int[] result = new int[nums.length - k + 1];

        // 2. 双端队列，存的是数组的【索引】而不是值
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            // A. 维护队列头部：如果队列头部的元素已经滑出当前窗口，移除它
            // 当前窗口的范围是 [i - k + 1, i]，所以如果 peek() < i - k + 1 就过期了
            if (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll(); // 弹出头部
            }

            // B. 维护队列单调性：如果当前进来的元素大于等于队列尾部元素，把尾部元素全部弹走
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast(); // 从尾部弹出
            }

            // C. 将当前元素的索引加入队列尾部
            deque.offer(i);

            // D. 记录答案：当窗口形成后（索引 i 走到 k - 1 时才算形成第一个完整窗口）
            if (i >= k - 1) {
                // 队列头部永远是当前窗口的最大值的索引
                result[i - k + 1] = nums[deque.peek()];
            }
        }

        return result;
    }
}
     */
}
