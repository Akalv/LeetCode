package LeetCode;

public class LeetCode1094 {
    // 根据每个行程更新每个上下车地点乘客的变化
    public boolean carPooling(int[][] trips, int capacity) {
        int[] change = new int[1001];
        for (int i = 0; i < trips.length; i++) {
            change[trips[i][1]] = change[trips[i][1]] + trips[i][0];
            change[trips[i][2]] = change[trips[i][2]] - trips[i][0];
        }
        int currTotal = 0;
        for (int i = 0; i < 1001; i++) {
            currTotal += change[i];
            if (currTotal > capacity) {
                return false;
            }
        }
        return true;
    }
}
