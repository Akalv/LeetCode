package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();

        dfsHelper(root, paths, "");

        return paths;
    }

    private void dfsHelper(TreeNode root, List<String> path, String currentPath) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            currentPath += (root.val + "");
            path.add(currentPath);
            return;
        }
        currentPath += (root.val + "->");
        dfsHelper(root.left, path, new String(currentPath));
        dfsHelper(root.right, path, new String(currentPath));
    }

}
