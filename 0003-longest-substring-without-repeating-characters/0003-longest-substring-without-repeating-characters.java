class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int hashLength = 256;
        int[] hash = new int[hashLength];
        Arrays.fill(hash, -1);
        int maxLen = 0;
        int left = 0, right = 0;
        while(right < n) {
            if(hash[s.charAt(right)] >= left) {
                left = Math.max(hash[s.charAt(right)] + 1, left);
            }
            int len = right - left + 1;
            maxLen = Math.max(maxLen, len);
            hash[s.charAt(right)] = right;
            right++;
        }
        return maxLen;
    }
}
