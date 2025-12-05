class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= n; i++) set.add(i);
        for (int num : nums)  set.remove(num);

        List<Integer> ans = new ArrayList<>(set);
        return ans;
    }
}