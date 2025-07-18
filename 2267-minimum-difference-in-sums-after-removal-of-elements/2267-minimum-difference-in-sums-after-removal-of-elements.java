class Solution {
    public long minimumDifference(int[] nums) {
        int n = nums.length;
        int k = n / 3;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // maximum sum
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a); // min sum
        long leftMin[] = new long[n];
        long rightMax[] = new long[n];
        long leftSum = 0, rightSum = 0, min = Long.MAX_VALUE;

        for (int i = 0; i < k; i++) {
            maxHeap.offer(nums[i]);
            leftSum += nums[i];
        }
        leftMin[k - 1] = leftSum;

        for (int i = k; i < n - k; i++) {
            int temp = nums[i];
            if (temp < maxHeap.peek()) {
                leftSum = leftSum + temp - maxHeap.poll();
                maxHeap.offer(temp);
            }
            leftMin[i] = leftSum;
        }

        for (int i = n - 1; i >= n - k; i--) {
            minHeap.offer(nums[i]);
            rightSum += nums[i];
        }
        rightMax[n - k] = rightSum;

        for (int i = n - k - 1; i >= k - 1; i--) {
            int temp = nums[i];
            if (temp > minHeap.peek()) {
                rightSum = rightSum + temp - minHeap.poll();
                minHeap.offer(temp);
            }
            rightMax[i] = rightSum;
        }

        for (int i = k - 1; i < n - k; i++) min = Math.min(min, leftMin[i] - rightMax[i + 1]);

        return min;

    }
}