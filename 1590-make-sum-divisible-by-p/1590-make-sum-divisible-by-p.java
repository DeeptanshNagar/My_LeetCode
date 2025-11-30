class Solution {
    public int minSubarray(int[] nums, int p) {
        long sum = 0;
        for (int num : nums) sum += num;

        int target = (int)(sum % p); 
        if (target == 0) return 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); 

        long prefixSum = 0;
        int minLength = nums.length;

        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            int curr = (int)(prefixSum % p);
            curr = (curr + p) % p;
            int reqd = (curr - target + p) % p;
            if (map.containsKey(reqd)) minLength = Math.min(minLength, i - map.get(reqd));
            map.put(curr, i);
        }
        return minLength == nums.length ? -1 : minLength;
    }
}