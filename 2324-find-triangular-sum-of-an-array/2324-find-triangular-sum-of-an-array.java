class Solution {
    public int triangularSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for (int num : nums) temp.add(num);
        list.add(temp);
        for (int i = 0; i < n - 1; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n - i - 1; j++) {
                row.add((list.get(i).get(j) + list.get(i).get(j + 1)) % 10);
            }
            list.add(row);
        }
        return list.get(list.size() - 1).get(0);
    }
}