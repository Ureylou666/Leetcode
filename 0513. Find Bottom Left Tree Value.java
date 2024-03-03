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
    public int findBottomLeftValue(TreeNode root) {
        List<Integer> treeNodes = new ArrayList<>();
        List<TreeNode> treeNodeList = new ArrayList<>();
        List<TreeNode> tempList = new ArrayList<>();
        treeNodeList.add(root);
        treeNodes.add(root.val);
        while (!treeNodeList.isEmpty()) {
            tempList.clear();
            treeNodes.clear();
            for (TreeNode node : treeNodeList) {
                if (node.left != null) {
                    tempList.add(node.left);
                    treeNodes.add(node.left.val);
                }
                if (node.right != null) {
                    tempList.add(node.right);
                    treeNodes.add(node.right.val);
                }
            }
            if (tempList.isEmpty()) {
                return treeNodeList.get(0).val;
            }
            treeNodeList.clear();
            treeNodeList.addAll(tempList);
        }
        return 0;
    }
}
