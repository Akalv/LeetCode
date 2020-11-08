package LeetCode;

public class LeetCode226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        TreeNode invertRoot = new TreeNode(root.val);
        dfsHelper(root, invertRoot);

        return invertRoot;
    }

    private void dfsHelper(TreeNode root, TreeNode invertRoot) {
        if (root == null) {
            return;
        }
        invertRoot.val = root.val;
        if (root.left != null) {
            invertRoot.right = new TreeNode(0);
            dfsHelper(root.left, invertRoot.right);
        }
        if (root.right != null) {
            invertRoot.left = new TreeNode(0);
            dfsHelper(root.right, invertRoot.left);
        }
    }
}
