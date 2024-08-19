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
    public static int sumNumbers(TreeNode root) {
        return sumTree(0, root);
    }

    private static int sumTree(int n, TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return n*10 + root.val;
        return sumTree(n*10+root.val , root.left) + sumTree(n*10+root.val, root.right);
    }
}
