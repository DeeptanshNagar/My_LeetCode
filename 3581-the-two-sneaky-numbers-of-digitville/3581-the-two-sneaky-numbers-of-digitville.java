class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int ans[] = new int[2];
        Set<Integer> set = new HashSet<>();
        int i = 0;
        for (int num : nums) {
            if (set.contains(num)) {
                ans[i++] = num;
                if (i == 2) return ans;
            }
            set.add(num);
        }
        return ans;
    }
}