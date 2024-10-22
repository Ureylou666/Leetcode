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
        System.out.println( addBinary( "11", "1")) ;

    }

    static List<Integer> list = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311, 313, 317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397, 401, 409, 419, 421, 431, 433, 439, 443, 449, 457, 461, 463, 467, 479, 487, 491, 499, 503, 509, 521, 523, 541, 547, 557, 563, 569, 571, 577, 587, 593, 599, 601, 607, 613, 617, 619, 631, 641, 643, 647, 653, 659, 661, 673, 677, 683, 691, 701, 709, 719, 727, 733, 739, 743, 751, 757, 761, 769, 773, 787, 797, 809, 811, 821, 823, 827, 829, 839, 853, 857, 859, 863, 877, 881, 883, 887, 907, 911, 919, 929, 937, 941, 947, 953, 967, 971, 977, 983, 991, 997);

    public static int minOperations(int[] nums) {
        int count = 0;
        boolean h;
        for (int i = nums.length-2; i >= 1; i--) if (nums[i] > nums[i+1]){
            int index = 0, temp = nums[i], temp2 = 1;
            h = false;
            if (nums[i+1] == 2) {
                if (nums[i] % 2 != 0 ) return -1; else {
                    if (nums[i] > 2) {
                        nums[i] = 2;
                        h = true;
                    }
                }
            } else {
                while (index < list.size() && list.get(index) < temp && nums[i] > nums[i + 1]) {
                    if (nums[i] % list.get(index) > 0) index++;
                    else {
                        nums[i] /= list.get(index);
                        h = true;
                        temp2 *= list.get(index);
                    }
                }
            }
            if (temp2 == temp && !h) return -1;
            if (h) count++;
            if (nums[i] > nums[i+1]) return -1;
        }
        for (int i = nums[1]; i>1 && nums[0] > nums[1]; i--) if (nums[0] % i ==0) {
            count++;
            break;
        }
        return count;
    }

    public static ListNode rotateRight(ListNode head, int k) {
        ListNode temp = head;
        int total = 0;
        while (temp != null) {
            temp = temp.next;
            total++;
        }
        k = total - k % total;
        temp = new ListNode();
        temp.next = head;
        while (head.next!=null) head=head.next;
        head.next= temp.next;
        while (k>=0) {
            temp =temp.next;
            k--;
        }
        ListNode dummy = new ListNode();
        dummy.next = temp;
        while (total >0) {
            temp = temp.next;
            total--;
        }
        temp.next= null;
        return dummy.next;
    }

    public static String addBinary(String a, String b) {
        a = new StringBuilder(a).reverse().toString();
        b = new StringBuilder(b).reverse().toString();
        int sum = 0;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < Math.max(a.length(), b.length()); i++) {
            if (i >= a.length()) sum += (b.charAt(i) - '0'); else if (i >= b.length()) sum += (a.charAt(i) - '0'); else sum += (a.charAt(i) - '0') + (b.charAt(i) - '0');
            if (sum == 3) {
                result.append("1");
                sum = 1;
            } else
            if (sum == 2) {
                result.append('0');
                sum = 1;
            } else {
                result.append(sum);
                sum = 0;
            }
        }
        if (sum > 0) result.append(sum);
        return result.reverse().toString();
    }
}