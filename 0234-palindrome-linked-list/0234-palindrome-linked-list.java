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
        ListNode temp = head;
        Stack<Integer> stk = new Stack<>();

        while(temp != null) {
            stk.push(temp.val);
            temp = temp.next;
        }

        temp = head;
        while(temp != null) {
            if(temp.val != stk.peek()) {
                return false;
            }
            stk.pop();
            temp = temp.next;
        }
        return true;
    }
}