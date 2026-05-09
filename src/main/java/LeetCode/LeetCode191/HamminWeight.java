package LeetCode.LeetCode191;

public class HamminWeight {

    public static void main(String[] args) {
        System.out.println(hammingWeight(2147483645));

    }

    public static int hammingWeight(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0){
            int i = n % 2;
            sb.append(i);
            n=n/2;
        }
        char[] charArray = sb.toString().toCharArray();
        int res=0;
        for (char c : charArray) {
            if (c == 49) {
                res++;
            }
        }
        return res;
    }
}
