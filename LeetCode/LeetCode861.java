package LeetCode;

public class LeetCode861 {
    /**
     * 对于任意一行而言，如果这一行的第一个数1，那么它的分数一定会比不是1要高。
     * 易得，对于每一行，如果该行第一位是0，则反转该行，否则不反转
     * @param A
     * @return
     */
    public int matrixScore(int[][] A) {
        int R = A.length, C = A[0].length;
        int ans = 0;
        for (int c = 0; c < C; ++c) {   // 循环每一列
            int col = 0;
            for (int r = 0; r < R; ++r) {   // 该列的每一行
                col += A[r][c] ^ A[r][0];   // 异或运算，当前列与首列异或，若首列为1，则该列为0时，col+1。

            }
            // 首位翻转每一行，确保首位必定为1
            // 随后对每列个数最多的情况，进行翻转
            ans += Math.max(col, R - col) * (1 << (C-1-c));
        }
        return ans;

    }
}
