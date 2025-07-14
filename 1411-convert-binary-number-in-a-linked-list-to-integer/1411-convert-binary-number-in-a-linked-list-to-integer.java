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
    public int getDecimalValue(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(String.valueOf(head.val));
            head = head.next;
        }
        int n = sb.length();
        int pow = (int)Math.pow(2, n - 1);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = ans + (sb.charAt(i) - '0') * pow;
            pow /= 2;
        }
        return ans;
    }
}