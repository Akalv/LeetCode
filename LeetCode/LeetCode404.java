package LeetCode;

public class LeetCode404 {

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return dfsHelper(root, false);
    }

    private int dfsHelper(TreeNode root, boolean isLeft) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null && isLeft) {
            return root.val;
        }

        int sum = 0;
        sum += dfsHelper(root.left, true);
        sum += dfsHelper(root.right, false);

        return sum;
    }
}
