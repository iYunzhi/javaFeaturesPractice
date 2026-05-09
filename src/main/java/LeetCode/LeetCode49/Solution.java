package LeetCode.LeetCode49;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }

        //原来的题解给出的是new ArrayList<List<String>>(map.values());,为什么我这样写也行？？
        //答：类型推断
        return new ArrayList<>(map.values());
    }
}
