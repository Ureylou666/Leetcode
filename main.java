import java.util.*;
import static java.lang.System.out;

class main {

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

    /**
     * @Description: arrayToListNode
     * @Author: Urey Lou
     * @Date: 2024-09-05
     * @Param: [inputs]
     * @return: ListNode
     */
    public static ListNode arrayToListNode(Integer[] inputs) {
        ListNode dummy = new ListNode(), result = new ListNode(0);
        dummy.next = result;
        for (Integer i : inputs) {
            result.next = new ListNode();
            result = result.next;
            result.val = i;
        }
        return dummy.next.next;
    }

    public static void main(String[] args) {
        // String grid2 = "[[0,0,0,0,0],[1,1,1,1,1],[0,1,0,1,0],[0,1,0,1,0],[1,0,0,0,1]]";
        //out.println( Math.pow(2,20) );
        out.println( ( minSetSize( new int[]{1000,1000,3,7}) )) ;
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {

    }

    public static String countOfAtoms(String formula) {
        HashMap<String, Integer> map = new HashMap<>();
        int index = 0, i = 0, count = 0;
        Stack<Character> stack = new Stack<>();
        while (i<formula.length() ){
            while (i<formula.length() && formula.charAt(i) != '(') i++;
            calc(map, formula.substring(index,i),1);
            if (i==formula.length()) break;

        }
        calc(map, formula, 1);
        return "";
    }

    private static void calc(HashMap<String, Integer> map, String s, int amount){
        HashMap<String , Integer> temp = new HashMap<>();
        int index = 0, i = 0, count = 0;
        while (i<=s.length() && index<s.length()) {
            if (i == s.length()) if (index<s.length()){
                String tempStr = s.substring(index, i);
                count = 1;
                if (temp.containsKey(tempStr)) {
                    count = count + temp.get(tempStr);
                    temp.put(tempStr, count);
                } else temp.put(tempStr, count);
                break;
            } else break;
            if ( (s.charAt(i) - 'A' >= 0 && Math.abs('Z'-s.charAt(i)) < 26)  || (s.charAt(i) - 'a' >= 0 && Math.abs('z'-s.charAt(i)) < 26))  i++;
            else {
                String tempStr = s.substring(index, i);
                count = 0;
                if ( (s.charAt(i)- '0' < 0 && '9'- s.charAt(i) > 9) ) count = 1; else {
                    while ( i< s.length() &&( s.charAt(i)-'0' >=0 && Math.abs('9'- s.charAt(i)) < 10) ) {
                        count = count *10 + s.charAt(i) - '0';
                        i++;
                    }
                }
                index = i;
                if (temp.containsKey(tempStr)) {
                    count = count + temp.get(tempStr);
                    temp.put(tempStr, count);
                } else temp.put(tempStr, count);
            }
        }
        for (String str : temp.keySet()) {
            count = temp.get(str) * amount;
            temp.put(str, count);
        }
        for (String str : temp.keySet()) {
            if (map.containsKey(str)) {
                count = map.get(str) + temp.get(str);
                map.put(str, count);
            } else map.put(str, temp.get(str));
        }
    }
}