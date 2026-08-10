class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> resultant = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        int i = 0;
        resultantFunction(nums, i, ans, resultant);
        return resultant;
    }

    public List<List<Integer>> resultantFunction(int[] nums, int i, List<Integer> ans, List<List<Integer>> resultant) {
        if(i == nums.length) {
            resultant.add(new ArrayList<>(ans));
            return resultant;
        }

        ans.add(nums[i]);
        resultantFunction(nums, i + 1, ans, resultant);

        ans.remove(ans.size() - 1);
        while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
            i++;
        }


        resultantFunction(nums, i + 1, ans, resultant);

        return resultant;
    }
}