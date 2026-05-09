package LeetCode.LeetCode349;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Solution {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,4,5,6,6,6,5};
        int[] nums2 = {3,4,5};

        System.out.println(Arrays.toString(intersectionOptimized(nums1, nums2)));
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> sumSet = new HashSet<>();
        for (int item : nums1) {
            sumSet.add(item);
        }
        for (int value : nums2) {
            sumSet.add(value);
        }
        HashSet<Integer> Set1 = new HashSet<>();
        for (int k : nums1) {
            Set1.add(k);
        }
        HashSet<Integer> Set2 = new HashSet<>();
        for (int j : nums2) {
            Set2.add(j);
        }
        // trans Set1,Set2 to int[]
        Object[] set1 = Set1.toArray();
        Object[] set2 = Set2.toArray();
        int[] num1 = new int[set1.length];
        int[] num2 = new int[set2.length];
        for (int i = 0; i < set1.length; i++) {
            num1[i] = (int) set1[i];
        }
        for (int i = 0; i < set2.length; i++) {
            num2[i] = (int) set2[i];
        }

        HashMap<Integer,Integer> map = new HashMap<>();
        for (int k : num1) {
            map.putIfAbsent(k, 0);
            map.put(k, map.get(k) + 1);
        }
        for (int j : num2) {
            map.putIfAbsent(j, 0);
            map.put(j, map.get(j) + 1);
        }
        List<Integer> list = new ArrayList<>();
        map.forEach((x,y) -> {
            if (y>1){
                list.add(x);
            }
        });

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static int[] intersectionOptimized(int[] nums1,int[] nums2){
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }
        for (int i : nums2) {
            if (set1.contains(i)){
                set2.add(i);
            }
        }
//        List<Integer> list = new ArrayList<>();
        int[] arr = new int[set2.size()];
        int k=0;
        for (Integer i : set2) {
            arr[k++] = i;
        }
        return arr;
    }
}
