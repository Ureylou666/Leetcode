/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        List<Integer> list = new ArrayList<>();
        do {
            list.add(head.val);
            head = head.next;
        } while (head != null);
        int[] array = list.stream().mapToInt(i->i).toArray();
        for (int i=0; i<array.length-1;i++) {
            for (int j=i+1; j<array.length;j++) {
                int sum = 0;
                for (int k=i;k<=j;k++) sum = sum+array[k];
                if (sum == 0) {
                    for (int k=i;k<=j;k++) array[k]=0;
                }
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int i=0; i<array.length;i++) {
            if (array[i] !=0) {
                current.next = new ListNode(array[i]);
                current = current.next;
            }
        }
        return dummy.next;
    }
}

--------------------------------------------------------------------------------
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        Map<Integer, ListNode> map = new HashMap<>();

        // First pass, build up the prefix sum map.
        int prefixSum = 0;
        for (ListNode i = dummy; i != null; i = i.next) {
            prefixSum += i.val;
            map.put(prefixSum, i);
        }

        // Second pass, check prefix sum and remove nodes.
        prefixSum = 0;
        for (ListNode i = dummy; i != null; i = i.next) {
            prefixSum += i.val;
            // If the prefix sum is in the map, it means there exists a sub-list sum up to 0, 
            // then we skip all nodes in the sub-list by pointing the next pointer to the node 
            // which has the same prefix sum.
            i.next = map.get(prefixSum).next;
        }

        return dummy.next;
    }
}
