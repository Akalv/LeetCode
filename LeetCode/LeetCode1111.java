package LeetCode;

public class LeetCode1111 {
    public int[] maxDepthAfterSplit(String seq) {
        // 现有的括号，按奇偶分开
        int[] res = new int[seq.length()];
        for (int i = 0; i < seq.length(); ++i) {
            if (seq.charAt(i) == '(') {
                res[i] = i % 2;
            } else {
                res[i] = 1 - i % 2;
            }
        }
        return res;
    }
}
