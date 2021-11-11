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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // edge case checking
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        int carry = 0;
        int sum = 0;
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        
        while (l1 != null || l2 != null) {
            sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            
            carry = sum / 10;
            
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            
            if (carry > 0) {
                cur.next = new ListNode(carry);
            }
        }
        return dummy.next;
    }
}
