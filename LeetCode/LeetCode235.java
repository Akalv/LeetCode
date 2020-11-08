package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pParentNode = new ArrayList<>();
        List<TreeNode> qParentNode = new ArrayList<>();

        dfsHelper(root, p, pParentNode);
        dfsHelper(root, q, qParentNode);

        pParentNode.add(p);
        qParentNode.add(q);

        TreeNode lowestNode = root;
        int i = 0, j = 0;
        while (i < pParentNode.size() && j < qParentNode.size()) {
            if (i >= pParentNode.size() -1 && j >= qParentNode.size() - 1) {
                break;
            }
            if (pParentNode.get(i).val == qParentNode.get(j).val) {
                lowestNode = pParentNode.get(i);
            }
            if (i < pParentNode.size() - 1) {
                i++;
            }
            if (j < qParentNode.size() - 1) {
                j++;
            }
        }
        return lowestNode;

    }

    private void dfsHelper(TreeNode root, TreeNode targetNode, List<TreeNode> parentNode) {
        if (root == null || root.val == targetNode.val) {
            return;
        }

        parentNode.add(root);

        if (root.val > targetNode.val) {
            dfsHelper(root.left, targetNode, parentNode);
        } else {
            dfsHelper(root.right, targetNode, parentNode);
        }

    }
}
