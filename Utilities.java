import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Utilities {

    /**
     * @Description: stringToArray
     * @Author: Urey Lou
     * @Date: 2024-08-28
     * @Param: [input]
     * @return: int[][]
     */
    public static int[][] stringToArray(String input){
        input = input.replaceAll(" ", "");
        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int i = 1, k =0 , j= 0;
        while (true)  {
            while ( (i<input.length()-1) && ((input.charAt(i) - '0' >= 10) || (input.charAt(i) - '0' < 0)) ) i++;
            if (i == input.length()-1) break;
            temp.clear();
            while (true) {
                k = 0;
                while ((input.charAt(i) != ',') && (input.charAt(i) != ']')) {
                    k = k * 10 + (input.charAt(i) - '0');
                    i++;
                }
                temp.add(k);
                if (input.charAt(i) == ',') i++;
                if (input.charAt(i) == ']') break;
            }
            resultList.add(new ArrayList<>(temp));
            i++;
            if (input.charAt(i) == ',') i++;
        }
        int n = resultList.size();
        int m = resultList.getFirst().size();
        int[][] result = new int[n][m];
        for (i = 0; i<n; i++){
            List<Integer> templist = new ArrayList<>();
            templist = resultList.get(i);
            for (j =0; j < m; j++) result[i][j] = templist.get(j);
        }
        return result;
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


}
