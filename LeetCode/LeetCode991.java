package LeetCode;

public class LeetCode991 {
    // 1024 1  X-Y
    // Y是奇数时 2x - 1 = y
    // Y是偶数时 2x = y
    public int brokenCalc(int X, int Y) {
        int res = 0;
        while (X < Y) {
            if (Y % 2 == 1) {
                Y++;
            } else {
                Y/=2;
            }
            res++;
        }
        return res + X - Y;
    }
}
