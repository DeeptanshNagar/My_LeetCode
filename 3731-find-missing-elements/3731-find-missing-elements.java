class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums);

        int currEle = nums[0];

        for(int i = 0 ; i < n; currEle++, i++){
            if(currEle < nums[i]){
                res.add(currEle);
                i--;
            }
        }
        return res;
    }
}