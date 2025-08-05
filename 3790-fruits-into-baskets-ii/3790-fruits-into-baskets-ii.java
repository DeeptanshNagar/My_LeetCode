class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        boolean[] visited = new boolean[n];
        int unplacedFruits = n;

        for (int fruit : fruits) {
            for (int i = 0; i < n; ++i) {
                if (baskets[i] >= fruit && !visited[i]) {
                    visited[i] = true;
                    --unplacedFruits;
                    break;
                }
            }
        }
        return unplacedFruits;
    }
}
