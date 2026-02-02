class Solution {
    public long minimumCost(int[] nums, int k, int dist) {
        long ans = Long.MAX_VALUE;
        int n = nums.length;
        TreeSet<Integer> maxHeap = new TreeSet<>((a, b) -> nums[a] == nums[b] ? b - a : nums[b] - nums[a]);
        TreeSet<Integer> minHeap = new TreeSet<>((a, b) -> nums[a] == nums[b] ? a - b : nums[a] - nums[b]);
           
        long sum = 0;
        for (int i = 1; i < Math.min((1 + dist), n); i++) minHeap.add(i);
        for (int i = 1; i < n; i++) {
            if (maxHeap.contains(i)) {
                sum -= nums[i];
                maxHeap.remove(i);
            }
            else minHeap.remove(i);

            if (i + dist < n) minHeap.add(i + dist);

            while (maxHeap.size() < k - 2 && minHeap.size() > 0) {
                int temp = minHeap.pollFirst();
                maxHeap.add(temp);
                sum += nums[temp];
            }

            while (maxHeap.size() > 0 && minHeap.size() > 0 && nums[maxHeap.first()] > nums[minHeap.first()]) {
                int temp = maxHeap.pollFirst();
                sum -= nums[temp];
                int temp2 = minHeap.pollFirst();
                sum += nums[temp2];
                maxHeap.add(temp2);
                minHeap.add(temp);
            }
            if (maxHeap.size() == k - 2) ans = Math.min(ans, nums[0] + nums[i] + sum);
        }
        return ans;
    }
}