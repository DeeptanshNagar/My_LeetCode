class Solution {
    public String smallestPalindrome(String s) {
        int n = s.length();
        int[] freq = new int[26];
        char[] result = s.toCharArray();

        for (int i = 0; i < n / 2; i++) {
            freq[s.charAt(i) - 'a']++;
        }

        int left = 0;

        for (int i = 0; i < 26; i++) {
            while (freq[i] > 0) {
                char ch = (char) ('a' + i);
                result[left] = ch;
                result[n - 1 - left] = ch;
                left++;
                freq[i]--;
            }
        }

        return new String(result);
    }
}