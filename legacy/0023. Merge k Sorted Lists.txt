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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a,b) -> a.val - b.val);
        ListNode dummy = new ListNode();
        ListNode result = dummy;
        ListNode temp;
        for (ListNode node : lists) if (node != null) queue.add(node);
        while (!queue.isEmpty()) {
            temp = queue.poll();
            dummy.next = temp;
            dummy = dummy.next;
            if (temp.next != null) queue.add(temp.next);
        }
        return result.next;
    }
}
