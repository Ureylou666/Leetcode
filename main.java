import java.util.*;

class main {

    public static void main (String[] args) {
        System.out.println( postorderTraversal( arrayToTreeNode( new Integer[]{1,null,2,3}  )  ) );
    }

    /**
     * @Description: arrayToTreeNode
     * @Author: Urey Lou
     * @Date: 2024-08-25
     * @Param: [inputs]
     * @return: TreeNode
     */
    public static TreeNode arrayToTreeNode(Integer[] inputs) {
        if (inputs == null || inputs.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(inputs[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while (i < inputs.length) {
            TreeNode currentNode = queue.poll();
            if (inputs[i] != null) {
                currentNode.left = new TreeNode(inputs[i]);
                queue.offer(currentNode.left);
            }
            i++;
            if (i < inputs.length && inputs[i] != null) {
                currentNode.right = new TreeNode(inputs[i]);
                queue.offer(currentNode.right);
            }
            i++;
        }
        return root;
    }

    /** 
    * @Description:
    * @Author: Urey Lou
    * @Date: 2024-08-25
    * @Param: [root]
    * @return: java.util.List<java.lang.Integer>
    */

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> find = new ArrayList<>();
        return recursive(root, find);
    }

    private static List<Integer> recursive(TreeNode top, List<Integer> list) {
        if (top.left == null && top.right == null) {
            list.add(top.val);
            return list;
        }
        if (top.left != null) {
           list =  recursive(top.left, list);
           list.add(top.val);
        }
        if (top.right != null) {
            list =  recursive(top.right, list);
            list.add(top.val);
        }
        return list;
    }

}