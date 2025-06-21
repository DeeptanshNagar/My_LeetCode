class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int n = nums1.length;
        int m = nums2.length;
        HashSet<Integer> ansSet = new HashSet<>();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                ansSet.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] ans = new int[ansSet.size()];
        int k = 0;
        for (int num : ansSet) {
            ans[k++] = num;
        }
        return ans;
    }
}