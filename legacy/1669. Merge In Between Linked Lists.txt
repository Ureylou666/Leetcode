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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode temp = new ListNode();
        dummy.next = list1;
        int i;
        for (i=0;i<a-1;i++) {
            list1 = list1.next;
        }
        temp.next = list1.next;
        for (i=a;i<=b;i++) temp=temp.next;
        list1.next = list2;
        while (list1.next != null) list1 = list1.next;
        list1.next = temp.next;
        return dummy.next;
    }
}
