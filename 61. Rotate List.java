class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // 1. Calculate length and find tail node
        ListNode tail = head;
        int len = 1;
        while (tail.next != null) {
            tail = tail.next;
            len++;
        }

        // 2. Reduce k using modulo
        k = k % len;
        if (k == 0) {
            return head;
        }

        // 3. Form a ring
        tail.next = head;

        // 4. Find new tail: (len - k) steps from the head
        int stepsToNewTail = len - k;
        ListNode newTail = head;
        for (int i = 1; i < stepsToNewTail; i++) {
            newTail = newTail.next;
        }

        // 5. Break the ring and return new head
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}
