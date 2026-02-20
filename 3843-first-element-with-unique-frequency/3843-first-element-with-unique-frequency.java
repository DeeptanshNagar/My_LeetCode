class Solution {
    public int firstUniqueFreq(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);
        Map<Integer, Integer> count = new HashMap<>();
        for (int val : map.values()) count.put(val, count.getOrDefault(val, 0) + 1);
        for (int num : nums) if (count.get(map.get(num)) == 1) return num;
        return -1;
    }
}