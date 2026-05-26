package LeetCode.LeetCode3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        String s = "abcdeabcdea";
        System.out.println(lengthOfLongestSubstring(s));
    }
    public static int lengthOfLongestSubstringOld(String s) {
            char[] charArray = s.toCharArray();
            if (charArray.length == 0){ return 0;}
            int n = charArray.length;
            int l = 0,r = 0;
            int ans = 0 , cnt = 0;

            Map<Character,Integer> map = new HashMap<>();
            while (r < n){
                char c = charArray[r++];
                map.put(c,map.getOrDefault(c,0) + 1);
                if (map.get(c) == 2){
                    cnt++;
                }

                while (cnt > 0){
                    char ch = charArray[l++];
                    map.put(ch,map.get(ch) - 1);
                    if (map.get(ch) == 1){
                        cnt--;
                    }
                }
                ans=Math.max(ans,r-l);
            }

            return ans;

    }

    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int max = 0;
        int left = 0; int right = 0;
        while (right < s.length()){
            while (set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            right++;
            max = Math.max(max,right-left);
        }
        return max;
    }
}
