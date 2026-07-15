class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node temp = head;

        // Step 1: Insert copy nodes in between original nodes
        while (temp != null) {

            Node copyNode = new Node(temp.val);

            copyNode.next = temp.next;
            temp.next = copyNode;

            temp = copyNode.next;
        }

        // Step 2: Assign random pointers
        temp = head;

        while (temp != null) {

            if (temp.random != null) {
                temp.next.random = temp.random.next;
            }

            temp = temp.next.next;
        }

        // Step 3: Separate the two linked lists
        temp = head;
        Node dummy = new Node(0);
        Node copy = dummy;
        while (temp != null) {

            copy.next = temp.next;
            copy = copy.next;

            temp.next = temp.next.next;
            temp = temp.next;
        }
        return dummy.next;
    }
}