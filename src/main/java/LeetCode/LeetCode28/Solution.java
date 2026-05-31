package LeetCode.LeetCode28;

public class Solution {


    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();

        for (int i = 0 ; i <= n - m ; i++){
            boolean flag = true;
            for (int j = 0 ; j < m ; j++){
                if (haystack.charAt(i + j) != needle.charAt(j)){
                    flag = false;
                    break;
                }
            }
            if (flag){
                return i;
            }
        }

        return -1;
    }
}
