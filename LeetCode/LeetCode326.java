package LeetCode;

public class LeetCode326 {
    // 建议看答案，普通写法是递归。这里一步步各种异想天开，挺精彩。
    public boolean isPowerOfThree(int n) {
        return n > 0 && 1162261467 % n == 0;
    }
}
