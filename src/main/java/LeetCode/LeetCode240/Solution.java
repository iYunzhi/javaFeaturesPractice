package LeetCode.LeetCode240;

import javax.naming.directory.SearchControls;
import java.util.ArrayList;
import java.util.List;
import java.util.MissingFormatArgumentException;

public class Solution {

    public static void main(String[] args) {
        int[][] matrix = {
                {1,3,5,7},
                {10,11,16,20},
                {23,30,34,60}
        };
        int target = 16;
//        List<List<Integer>> list = new ArrayList<>();
//
//        System.out.println(matrix.length);
//        for (int[] ints : matrix) {
//            List<Integer> array = new ArrayList<>();
//            for (int j = 0; j < matrix[0].length; j++) {
//                int single = ints[j];
//                array.add(single);
//            }
//            list.add(array);
//        }
//
//        int row = list.size();
//        int col = list.get(0).size();
//        System.out.println(list.get(row - 1).get(col-1));
        System.out.println(searchMatrixOptimized(matrix, 16));
    }


    /**
     * 在一个 m x n 的矩阵中搜索一个目标值。
     * 该矩阵具有以下特性：
     * 1. 每行中的整数从左到右按升序排列。
     * 2. 每行的第一个整数大于前一行的最后一个整数。
     *
     * @param matrix m x n 矩阵
     * @param target 要搜索的目标值
     * @return 如果目标值存在于矩阵中，则返回 true，否则返回 false
     */
    public static boolean searchMatrix(int[][] matrix, int target){
        // --- 原始代码逻辑分析 ---
        // 1. 数据结构转换：原始代码首先将 int[][] 数组转换为 List<List<Integer>>。
        //    这个转换过程需要遍历矩阵中的每一个元素，时间复杂度为 O(m*n)，其中 m 是行数，n 是列数。
        //    同时，这也会消耗额外的 O(m*n) 空间来存储新的 List。
        List<List<Integer>> list = new ArrayList<>();

        System.out.println(matrix.length);
        for (int[] ints : matrix) {
            List<Integer> array = new ArrayList<>();
            for (int j = 0; j < matrix[0].length; j++) {
                int single = ints[j];
                array.add(single);
            }
            list.add(array);
        }

        int row = list.size();
        int col = list.get(0).size();

        // 2. 边界检查：快速判断目标值是否可能存在于矩阵中。
        //    如果 target 小于矩阵的最小元素或大于最大元素，则直接返回 false。这是一个 O(1) 的有效剪枝。
        if (target < list.get(0).get(0)){return false;}
        if (target > list.get(row-1).get(col-1)){return false;}

        // 3. 逐行线性搜索：
        //    - 外层循环遍历每一行。在最坏情况下，需要遍历 m 行。
        //    - 内层循环在确定目标值可能在某一行后，对该行进行线性搜索。在最坏情况下，需要遍历 n 个元素。
        //    - 这种搜索方式没有充分利用“行已排序”和“行间有序”的特性。
        for (List<Integer> integers : list) {
            if (target >= integers.get(0) && target <= integers.get(col - 1)) {
                for (Integer integer : integers) {
                    if (integer == target) {
                        return true;
                    }
                }
            }
        }

        // --- 时间复杂度分析 ---
        // - 数据转换：O(m*n)
        // - 搜索过程：外层循环 O(m)，内层循环 O(n)，总共是 O(m*n)。
        // - 总体时间复杂度：O(m*n) + O(m*n) = O(m*n)。
        // - 空间复杂度：O(m*n)，用于存储转换后的 List。

        // --- 优化建议 ---
        // 鉴于矩阵的特性（整体有序），可以将搜索算法优化为二分查找，从而显著降低时间复杂度。
        //
        // 优化方案1：将矩阵视为一个虚拟的有序一维数组
        // - 核心思想：将二维坐标 (row, col) 映射到一维索引 index = row * n + col。
        // - 算法步骤：
        //   1. 初始化二分查找的左右指针：left = 0, right = m * n - 1。
        //   2. 在 while (left <= right) 循环中，计算中间索引 mid = left + (right - left) / 2。
        //   3. 将一维索引 mid 转换回二维坐标：
        //      - rowIndex = mid / n
        //      - colIndex = mid % n
        //   4. 获取中间值 midVal = matrix[rowIndex][colIndex]。
        //   5. 比较 midVal 和 target：
        //      - 如果 midVal == target，查找成功，返回 true。
        //      - 如果 midVal < target，说明目标值在右半部分，更新 left = mid + 1。
        //      - 如果 midVal > target，说明目标值在左半部分，更新 right = mid - 1。
        //   6. 如果循环结束仍未找到，返回 false。
        //
        // - 优化后时间复杂度：O(log(m*n))。
        // - 优化后空间复杂度：O(1)，因为不需要额外的数据结构。
        // - 这种方法是解决此类问题的最优解法。

        return false;
    }

    public static boolean searchMatrixOptimized(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;

        int left = 0; int right = row * col - 1; int mid; int rowIdx; int colIdx;
        while (left <= right){
            mid = left + (right - left) / 2;
            rowIdx = mid / col;
            colIdx = mid % col;

            if (target == matrix[rowIdx][colIdx]){
                return true;
            }
            if (target < matrix[rowIdx][colIdx]){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return false;
    }


}
