package LeetCode.LeetCode233;

public class Solution {
    public static void main(String[] args) {
        long begin = System.currentTimeMillis();
        System.out.println(digitOneInNumber(824883294));
        long end = System.currentTimeMillis();
        long duration = (end - begin)/ 1000;
        System.out.println(duration);
    }
    public static int digitOneInNumber(int num) {
        int res = 0;
        for (int i = 0; i <= num; i++) {
            res = res + singleOneInNumber(i);
        }
        return res;
    }

    public static int singleOneInNumber(int num){
        int count = 0;
        int temp;
        while (num != 0){
            temp = num % 10;
            if (temp == 1){
                count++;
            }
            num = num / 10;
        }
        return count;
    }
}
