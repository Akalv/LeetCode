package LeetCode;

/**
 * 移动偶数步无代价，移动奇数步代价1，则找出数组中奇偶数个数，将数量较少的一方移动奇数bu，为结果
 */
public class LeetCode1217 {
    public int minCostToMoveChips(int[] chips) {
        int num1 = 0, num2 = 0;
        for (int i = 0; i < chips.length; i++) {
            if (chips[i] % 2 == 1) {
                num1++;
            } else {
                num2++;
            }
        }
        return num1 > num2 ? num2 : num1;
    }
}
