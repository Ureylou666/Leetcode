/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        List<TreeNode> treeNodeList = new ArrayList<>();
        List<TreeNode> temp = new ArrayList<>();
        treeNodeList.add(root);
        while (depth > 2) {
            temp.clear();
            for (TreeNode node : treeNodeList) {
                if (node.left != null) temp.add(node.left);
                if (node.right != null) temp.add(node.right);
            }
            treeNodeList.clear();
            for (TreeNode node:temp) treeNodeList.add(node);
            depth--;
        }
        for (TreeNode node : treeNodeList) {
            TreeNode newLeft = new TreeNode(val), newRight = new TreeNode(val);
            newLeft.left = node.left;
            node.left = newLeft;
            newRight.right = node.right;
            node.right = newRight;
        }
        return root;
    }
}
