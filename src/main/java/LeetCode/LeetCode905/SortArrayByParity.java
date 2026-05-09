package LeetCode.LeetCode905;

import java.util.ArrayList;
import java.util.Arrays;

public class SortArrayByParity {
    public static void main(String[] args) {
        int[] a = {3,1,4,2};
        System.out.println(Arrays.toString(sortArrayByParity(a)));
    }

    public static int[] sortArrayByParity(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();
        ArrayList<Integer> res1 = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        for (Integer t : list) {
            if (t % 2 == 0) {
                res.add(t);
            }
        }
        for (Integer t : list) {
            if (t % 2 != 0){
                res1.add(t);
            }
        }
        res.addAll(res1);
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i]=res.get(i);
        }
        return result;
    }

}
