package LeetCode;

import java.util.Arrays;

public class LeetCode955 {
    // 首先没有任意列保留，对于每一列：如果保留后结果保持有序，就保留这一列；否则删除它
    public int minDeletionSize(String[] A) {
        int N = A.length;
        int W = A[0].length();
        int ans = 0;

        String[] cur = new String[N];
        for (int j = 0; j < W; ++j) {
            String[] cur2 = Arrays.copyOf(cur, N);
            for (int i = 0; i < N; ++i) {
                cur2[i] += A[i].charAt(j);
            }

            if (isSorted(cur2)) cur = cur2;
            else ans++;
        }
        return ans;
    }

    public boolean isSorted(String[] A) {
        for (int i = 0; i < A.length - 1; ++i) {
            if (A[i].compareTo(A[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }
}
