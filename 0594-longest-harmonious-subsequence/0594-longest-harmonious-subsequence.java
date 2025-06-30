class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        int maxLen = 0;

        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        for (int num : freqMap.keySet()) {
            if (freqMap.containsKey(num + 1)) {
                int combined = freqMap.get(num) + freqMap.get(num + 1);
                maxLen = Math.max(maxLen, combined);
            }
        }

        return maxLen;
    }
}