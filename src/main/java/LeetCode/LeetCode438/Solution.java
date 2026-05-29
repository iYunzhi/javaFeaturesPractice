package LeetCode.LeetCode438;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findAnagrams("cbaebabacd", "abc").toString());
    }
    //TODO 优化成int[26]数组 curChar - 'a'
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();

        char[] sArr = s.toCharArray();
        char[] pArr = p.toCharArray();
        int left = 0; int right = 0;

        HashMap<Character,Integer> sMap = new HashMap<>();
        HashMap<Character,Integer> pMap = new HashMap<>();

        for (char c : pArr) {
            pMap.put(c,pMap.getOrDefault(c,0) + 1);
        }

        while (right < sArr.length){
            sMap.put(sArr[right],sMap.getOrDefault(sArr[right],0) + 1);

            if (right - left + 1 == pArr.length) {
                if(sMap.equals(pMap)) {
                    res.add(left);
                }
                sMap.put(sArr[left], sMap.get(sArr[left]) - 1);
                if (sMap.get(sArr[left]) == 0) {
                    sMap.remove(sArr[left]);
                }
                left++;
            }


            right++;
        }
        return res;
    }
}
