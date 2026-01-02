class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int n = nums1.length;
        int m = nums2.length;
        List<Integer> list = new ArrayList<>();
        int i = 0, j = 0;
        while(i < n && j < m) {
            if(nums1[i] == nums2[j]) {
                list.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                i++;
            }
        }
        int[] ans = new int[list.size()];
        for(int k = 0; k < list.size(); k++) {
            ans[k] = list.get(k);
        }
        return ans;
    }
}