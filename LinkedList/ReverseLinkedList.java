// Iterative Solution:
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            // reverse
            cur.next = prev;
            // walk
            prev = cur;
            cur = next;
        }
        return prev;
    }
}


// Recursive Solution:
class Solution {
    public ListNode reverseList(ListNode head) {
        // base case
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
        
    }
}