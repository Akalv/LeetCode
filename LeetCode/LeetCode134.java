package LeetCode;

public class LeetCode134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;

        int totalTank = 0;
        int currTank = 0;
        int startIndex = 0;
        for (int i = 0; i < n; ++i) {
            totalTank += gas[i] - cost[i];
            currTank += gas[i] - cost[i];
            if (currTank < 0) {
                startIndex = i + 1;
                currTank = 0;
            }
        }
        return totalTank >= 0 ? startIndex : -1;
    }
}
