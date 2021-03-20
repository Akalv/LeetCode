package LeetCode;

public class LeetCode852 {
    // On的解法很容易想到，能不能想一个Ologn的解法？
    public int peakIndexInMountainArray(int[] arr) {
        int len = arr.length;
        int right = len - 1;
        int left = 0;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mid - 1 >= 0 && mid + 1 < len) {
                if (arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1]) {
                    left = mid + 1;
                } else if (arr[mid - 1] > arr[mid]) {
                    right = mid;
                } else if (arr[mid - 1] < arr[mid]) {
                    left = mid;
                }
            } else {
                return -1;
            }
        }

        return left - 1;
    }
}
