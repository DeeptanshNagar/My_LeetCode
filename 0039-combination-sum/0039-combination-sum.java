class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        int i = 0;
        int sum = 0;
        resultantFunction(candidates, i, sum, target, ans, result);
        return result;
    }
    
    public List<List<Integer>> resultantFunction(int[] candidates, int i, int sum, int target, List<Integer> ans, List<List<Integer>> result) {
        if(sum == target) {
            result.add(new ArrayList<>(ans));
            return result;
        }
        if (i >= candidates.length || sum > target) {
            return result;
        }

        ans.add(candidates[i]);
        sum = sum + candidates[i];
        resultantFunction(candidates, i, sum, target, ans, result);
        ans.remove(ans.size() - 1);
        sum = sum - candidates[i];
        resultantFunction(candidates, i + 1, sum, target, ans, result);

        return result;
    }
}