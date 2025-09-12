class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer, Integer> hmp = new HashMap<>();
        for(int num : nums) {
            hmp.put(num, hmp.getOrDefault(num, 0) + 1);
        }

        int maxFrq = 0;
        for(int count : hmp.values()) {
            maxFrq = Math.max(maxFrq, count);
        }

        int total = 0;
        for(int count : hmp.values()) {
            if(count == maxFrq) {
                total = total + count;
            }
        }
        return total;
    }
}