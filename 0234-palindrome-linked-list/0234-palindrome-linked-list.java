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
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) {
            return true;
        }

        // list ka middle dundenge
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // reversing 2nd half
        ListNode secondHalf  = reverseLL(slow.next);

        // compare both halves
        ListNode first = head;
        ListNode second = secondHalf;
        while(second != null) {
            if(first.val != second.val) {
                reverseLL(secondHalf); // restoringg original LL...
                return false;
            }
            first = first.next;
            second = second.next;
        }
        reverseLL(secondHalf);
        return true;
    }
    ListNode reverseLL(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}