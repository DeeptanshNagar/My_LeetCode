/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode temp = head;
        HashSet<ListNode> nodeMap = new HashSet<>();
        while (temp != null) {
            if (nodeMap.contains(temp)) {
                return true;
            }
            nodeMap.add(temp);
            temp = temp.next;
        }
        return false;
    }
}