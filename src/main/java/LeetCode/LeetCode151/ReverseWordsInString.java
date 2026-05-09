package LeetCode.LeetCode151;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class ReverseWordsInString {
    public static void main(String[] args) {
//        ArrayList<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.add(4);
//
//        for (int i = list.size()-1; i >= 0; i--) {
//            System.out.println(list.get(i));}
        System.out.println(reverseWords("the sky is blue"));

        StringBuilder sb = new StringBuilder();
        sb.append("0123456789");
        System.out.println(sb.substring(0, sb.length()-1));

    }

    public static String reverseWords(String s) {
        StringTokenizer st = new StringTokenizer(s," ");
        List<String> list = new ArrayList<>();

        while (st.hasMoreTokens()){
            list.add(st.nextToken());
        }
        StringBuilder sb = new StringBuilder();
        for (int i = list.size()-1; i >= 0; i--) {
            sb.append(list.get(i));
            sb.append(" ");
        }
        return sb.substring(0,sb.length()-1);
    }
}
