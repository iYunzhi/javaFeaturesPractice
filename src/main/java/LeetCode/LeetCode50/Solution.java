package LeetCode.LeetCode50;

class Solution {

    public static void main(String[] args) {
        int n = 13;

        while (n > 0){
            System.out.println(n);
            n = n >> 1;
        }
        System.out.println(n);
    }

    public static double myPow(double x, int n) {
        double result = 1.0;
        long N = n;
        if (n < 0){
            x = 1 / x;
            N = -N;
        }
        while (N > 0) {
            if ((N & 1) == 1) {
                result = result * x;
            }
            x *= x;
            N >>= 1;
        }
        return result;
        //微软雅黑
    }

    /*
    ====================================================================
    优化方案：快速幂算法 (Binary Exponentiation)
    ====================================================================

    你当前的代码使用了简单的循环，时间复杂度为 O(n)，在 n 非常大时会导致超时。
    下面的 `myPow_optimized` 方法使用了快速幂算法，可以将时间复杂度优化到 O(log n)。

    核心思想：
    1. 利用指数的二进制表示。例如 x^77 = x^(64+8+4+1) = x^64 * x^8 * x^4 * x^1。
    2. 通过迭代，我们每次让底数 x 自乘 (x -> x^2 -> x^4 ...)，这对应了指数的二进制位。
    3. 同时，我们检查指数 n 的二进制位。如果当前位是 1，我们就把对应的底数幂乘到最终结果上。

    public static double myPow_optimized(double x, int n) {
        // 将 n 转换为 long 类型，以处理 n = Integer.MIN_VALUE (-2147483648) 的特殊情况。
        // 如果 n 是 Integer.MIN_VALUE, -n 会导致 int 溢出，但 long 不会。
        long N = n;
        double result = 1.0;

        // 如果指数是负数，我们可以先计算 x 的 -N 次幂，然后取其倒数。
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        // 快速幂的迭代实现
        while (N > 0) {
            // 判断 N 的二进制最低位是否为 1。
            // (N & 1) == 1 和 (N % 2) == 1 是等价的，但位运算通常更快。
            if ((N & 1) == 1) {
                // 如果最低位为 1，表示当前 x 的幂次是构成最终结果的一部分，需要乘进去。
                result = result * x;
            }
            // 将底数平方，为下一次迭代做准备。
            // 无论 N 的当前位是 0 还是 1，底数都需要平方来“前进”到下一个幂次 (x -> x^2 -> x^4 ...)。
            x = x * x;
            // N 右移一位，相当于 N = N / 2，去掉已经处理过的最低位。
            N >>= 1;
        }
        return result;
    }
    */
}
