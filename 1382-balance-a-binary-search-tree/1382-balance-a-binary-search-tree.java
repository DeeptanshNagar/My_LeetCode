class Solution {
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        inorder(root, values);

        return balance(values, 0, values.size() - 1);
    }

    public void inorder(TreeNode node, List<Integer> values) {
        if (node == null) return;

        inorder(node.left, values);
        values.add(node.val);
        inorder(node.right, values);
    }

    public TreeNode balance(List<Integer> values, int left, int right) {
        if (left > right) return null;

        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(values.get(mid));

        node.left = balance(values, left, mid - 1);
        node.right = balance(values, mid + 1, right);

        return node;
    }
}