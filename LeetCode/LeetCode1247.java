package LeetCode;

public class LeetCode1247 {
    public int minimumSwap(String s1, String s2) {
        int len = s1.length(), xy = 0, yx = 0;
        for (int i = 0; i < len; i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                continue;
            } else if (s1.charAt(i) == 120) {
                xy++;
            } else {
                yx++;
            }
        }
        return ((xy + yx) & 1) == 1 ? -1 : (xy + 1) / 2 + (yx + 1) / 2;
    }

}
