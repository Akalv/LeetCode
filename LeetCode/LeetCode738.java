package LeetCode;

public class LeetCode738 {

    /**
     * 贪心：对于N的每一位数字，我们构建答案ans的下一位数字。
     * 我们找到数字d，其中d满足ans + (d repeating) > N（按字符串比较）且d-1满足ans + (d-1 repeating)<=N,因此我们将d-1添加到我们的答案中。
     * 如果找不到这样一个数字d，则在答案中添加9
     * @param N
     * @return
     */
    public int monotoneIncreasingDigits(int N) {
        String s = String.valueOf(N);
        String ans = "";
        search: for (int i = 0; i < s.length(); ++i) {
            for (char d = '1'; d <= '9'; ++d) {
                if (s.compareTo(ans + repeat(d, s.length() - i)) < 0) {
                    ans += (char)(d - 1);
                    continue search;
                }
            }
            ans += '9';
        }
        return Integer.parseInt(ans);
    }

    public String repeat(char c, int count) {
        StringBuilder sb = new StringBuilder(count);
        for (int i = 0; i < count; ++i) {
            sb.append(c);
        }
        return sb.toString();
    }

    /**
     * 首先想到的是，我们总是可以得到一个 d999...9 的候选答案（其中 0 <= d <= 9 后接一些数字9）。例如，如果 n=432543654，我们总是可以得到至少 39999999 的答案。
     * 我们可以进行优化。例如，当数字是 123454321 时，我们可以有一个 123449999 的候选候选答案。这似乎是一个不错的策略，就是采用一个单调递增的前缀，然后在相邻的数字首次下降的索引之前（悬崖）减少这个数字，然后用 9 代替其余的字符。
     * 这种策略什么时候会出错？如果 n=333222，那么我们的策略将给出 332999 的候选答案，但这不是单调递增的。
     * 因此，我们可以修复我们的策略，通过线性扫描成功地变形成最终的答案 332999->329999->299999。
     *
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/monotone-increasing-digits/solution/dan-diao-di-zeng-de-shu-zi-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param N
     * @return
     */
    public int monotoneIncreasingDigits1(int N) {
        char[] s = String.valueOf(N).toCharArray();
        int i = 1;
        while (i < s.length && s[i - 1] <= s[i]) i++;
        while (0 < i && i < s.length && s[i - 1] > s[i]) s[--i]--;
        for (int j = i + 1; j < s.length; ++j) s[j] = '9';

        return Integer.parseInt(String.valueOf(s));
    }
}
