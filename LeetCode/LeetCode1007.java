package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode1007 {

    public int check(int x, int[] A, int[] B, int n) {
        int rotationA = 0, rotationB = 0;
        for (int i = 0; i < n; i++) {
            if (A[i] != x && B[i] != x) {
                return -1;
            } else if (A[i] != x) {
                rotationA++;
            } else if (B[i] != x) {
                rotationB++;
            }
        }

        return Math.min(rotationA, rotationB);
    }

    public int minDominoRotations(int[] A, int[] B) {
        int n = A.length;
        int rotation = check(A[0], B, A, n);
        if (rotation != -1 || A[0] == B[0]) {
            return rotation;
        } else {
            return check(B[0], B, A, n);
        }
    }

}
