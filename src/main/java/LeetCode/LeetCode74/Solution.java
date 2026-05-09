package LeetCode.LeetCode74;

import javax.swing.plaf.metal.MetalBorders;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {

        int[][] matrix = {
                {2, 3, 6, 8},
                {4, 5, 8, 9},
                {5, 9, 10, 12}
        };

        int[][] matrix1 ={};
//        System.out.println(findTargetIn2DPlants(matrix1,3));
//
//        System.out.println(findTargetIn2DPlants(matrix, 7));
        System.out.println(findTargetIn2DPlantsOptimized(matrix, 2));
    }

    /**
     * 每行中，每棵植物的右侧相邻植物不矮于该植物.
     * 每列中，每棵植物的下侧相邻植物不矮于该植物.
     * @param plants plants
     * @param target target plant
     * @return whether exist in provided plants
     */
    public static boolean findTargetIn2DPlants(int[][] plants, int target) {
        if (plants.length == 0){
            return false;
        }
        int row = plants.length;
        int col = plants[0].length;
        for (int i = 0; i <= row-1;i++){
            for (int j = 0;j <= col-1;j++){
                int cur = plants[i][j];
                if (cur == target){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean findTargetIn2DPlantsOptimized(int[][] plants, int target){
        if (plants.length == 0){
            return false;
        }
        int row = plants.length;
        int col = plants[0].length;
        int flat = row * col;
        int[] flatArray = new int[flat];
        int k = 0;
        for (int i = 0;i <= row-1;i++){
            for (int j = 0;j <= col-1;j++){
                flatArray[k] = plants[i][j];
                k++;
            }
        }
        Arrays.sort(flatArray);
        return midSearch(flatArray, target);
    }

    public static boolean midSearch(int[] array,int target){
        int left = 0;
        int right = array.length - 1;
        int mid;
        while (left<=right){
            mid = left + (right - left) /2;
            if (array[mid] == target){
                return true;
            } else if (array[mid] > target){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }





}
