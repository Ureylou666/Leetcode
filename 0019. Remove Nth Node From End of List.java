public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        //第一个指针先移动 n 步
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        //第一个指针到达终点停止遍历
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
