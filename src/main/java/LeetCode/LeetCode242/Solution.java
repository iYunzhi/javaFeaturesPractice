package LeetCode.LeetCode242;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

public class Solution {
    public static void main(String[] args) {
        String s = "aacc";
        String t = "ccac";

        char c0 = 'b';
        System.out.println(c0 - 'a');

        System.out.println(isAnagram(s, t));
    }
    public static boolean isAnagram(String s, String t) {
        if (s.equals(t)){
            return false;
        }
        if(s.length() != t.length()){
            return false;
        }

        HashMap<Character,Integer> sMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char curs = s.charAt(i);
            sMap.put(curs, sMap.getOrDefault(curs,0) +1);
        }

        HashMap<Character,Integer> tMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char curt = t.charAt(i);
            tMap.put(curt,tMap.getOrDefault(curt,0) +1);
        }

        for (int i = 0; i < t.length(); i++) {
            char curr = t.charAt(i);
            Integer sV = sMap.get(curr);
            Integer tV = tMap.get(curr);
            if(sV == null || tV == null){
                return false;
            }
            if (sV.intValue() != tV.intValue()){
                return false;
            }
        }

        return true;
    }

    //数组法
    public static boolean isAnagramPlus(String s,String t){
        if (s.equals(t) || s.length() != t.length()){
            return false;
        }

        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for (int i : count) {
            if (i != 0){
                return false;
            }
        }

        return true;
    }

    //极简排序法
    public static boolean isAnagramX(String s,String t){
        if (s.equals(t) || s.length() != t.length()){
            return false;
        }

        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();

        Arrays.sort(sCharArray);
        Arrays.sort(tCharArray);

        return Arrays.equals(sCharArray, tCharArray);
    }
}
