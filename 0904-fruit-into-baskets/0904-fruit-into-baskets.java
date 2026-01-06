class Solution {
    public int totalFruit(int[] arr) {
        int n = arr.length;
		int maxLen = 0;
		int left = 0;
		int right = 0;
		HashMap<Integer, Integer> mpp = new HashMap<>();

		while(right < n) {
			mpp.put(arr[right], mpp.getOrDefault(arr[right], 0) + 1);

			while(mpp.size() > 2) {
				mpp.put(arr[left], mpp.get(arr[left]) - 1);
				if(mpp.get(arr[left]) == 0) {
					mpp.remove(arr[left]);
				}
				left++;
			}

			maxLen = Math.max(maxLen, right - left + 1);
			right++;
		}
		return maxLen;
    }
}