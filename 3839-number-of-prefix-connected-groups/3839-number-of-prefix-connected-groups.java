class Solution {
    public int prefixConnected(String[] words, int k) {
        Map<String, Integer> count = new HashMap<>();
        for (String word : words) {
            if (word.length() < k) continue;
            String pref = word.substring(0, k);
            count.put(pref, count.getOrDefault(pref, 0) + 1);
        }
        int ans = 0;
        for (int c : count.values()) if (c >= 2) ans++;
        return ans;
    }
}