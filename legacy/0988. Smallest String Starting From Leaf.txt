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
    public static List<Integer> nodeList = new ArrayList<>();
    public static List<Integer> minList = new ArrayList<>();

    public static String smallestFromLeaf(TreeNode root) {
        nodeList.clear();
        minList.clear();
        DFS(root);
        StringBuilder sb = new StringBuilder();
        for (int i = minList.size()-1; i>=0; i--) {
            sb.append( (char)  (minList.get(i) + 'a') );
        }
        return sb.toString();
    }

    private static void DFS(TreeNode root) {
        nodeList.add(root.val);
        if (root.left == null && root.right == null) {
            compare(nodeList);
            return;
        }
        if (root.left != null) {
            DFS(root.left);
            nodeList.remove(nodeList.size()-1);
        }
        if (root.right != null) {
            DFS(root.right);
            nodeList.remove(nodeList.size()-1);
        }
    }

    private static void compare(List<Integer> list1) {
        if (minList.isEmpty()) {
            minList.addAll(list1);
            return;
        }
        int i = list1.size()-1, j =  minList.size()-1;
        while (j >= 0 && i>=0) {
            if (minList.get(j) > list1.get(i)) {
                minList.clear();
                minList.addAll(list1);
                return;
            } else if (minList.get(j) < list1.get(i)) return;
            i--;
            j--;
        }
        if (j >= 0 && i<0 && minList.get(j) >= list1.get(0)) {
            minList.clear();
            minList.addAll(list1);
        }
    }
}
