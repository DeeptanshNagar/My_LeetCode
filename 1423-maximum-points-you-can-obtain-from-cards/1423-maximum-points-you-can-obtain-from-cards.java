class Solution {
    public int maxScore(int[] arr, int k) {
        int maxSum = 0;
		int leftSum = 0;
		int rightSum = 0;

		for (int i = 0; i < k; i++) {
			leftSum = leftSum + arr[i];
		}
		maxSum = leftSum;

		int rightIndex = arr.length - 1;

		for (int j = k - 1; j >= 0; j--) {
			leftSum = leftSum - arr[j];
			rightSum = rightSum + arr[rightIndex];
			rightIndex--;
			maxSum = Math.max(maxSum, leftSum + rightSum);
		}
		return maxSum;
    }
}