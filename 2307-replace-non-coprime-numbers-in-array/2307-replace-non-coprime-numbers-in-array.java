class Solution {
    public int hcf(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return Math.abs(a);
    }

    public List<Integer> replaceNonCoprimes(int[] nums) {
        Deque<Long> st = new ArrayDeque<>();
        for (int x : nums) {
            long curr = x;
            while (!st.isEmpty()) {
                long factor = hcf((int) st.peekLast().longValue(), (int) curr);
                if (factor == 1) break;
                curr = (st.pollLast() / factor) * curr;
            }
            st.addLast(curr);
        }
        List<Integer> ans = new ArrayList<>(st.size());
        for (long v : st) ans.add((int) v);
        return ans;
    }
}