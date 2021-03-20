package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * 重建二叉树,cv大法
 */
public class JianZhi07 {
    private Map<Integer, Integer> indexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return dfsBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    private TreeNode dfsBuildTree(int[] preorder, int[] inorder, int preOrderLeft, int preOrderRight, int inOrderLeft, int inOrderRight) {
        if (preOrderLeft > preOrderRight) {
            return null;
        }

        int preOrderRoot = preOrderLeft;
        int inOrderRoot = indexMap.get(preorder[preOrderRoot]);

        // 先把根节点建立出来
        TreeNode root = new TreeNode(preorder[preOrderRoot]);

        int leftSubTreeSize = inOrderRoot - inOrderLeft;

        root.left = dfsBuildTree(preorder, inorder, preOrderLeft + 1, preOrderLeft + leftSubTreeSize, inOrderLeft, inOrderRoot - 1);

        root.right = dfsBuildTree(preorder, inorder, preOrderLeft + 1 + leftSubTreeSize, preOrderRight, inOrderRoot + 1, inOrderRight);

        return root;
    }
}
