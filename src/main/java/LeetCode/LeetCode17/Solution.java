package LeetCode.LeetCode17;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private static final String[] MAPPRING = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();

        int n = digits.length();
        if (n == 0){
            return ans;
        }
        char[] path = new char[n];

        dfs(digits,0,ans,path);

        return ans;
    }

    private void dfs(String digits, int i, List<String> ans, char[] path) {
        if (i == digits.length()){
            ans.add(new String(path));
            return;
        }

        int index = digits.charAt(i) - '0';
        String letter = MAPPRING[index];

        for (char c : letter.toCharArray()) {
            path[i] = c;
            dfs(digits,i+1,ans,path);
        }
    }
}
