class Solution {
    public int longestBalanced(String s) {
        int ans = 1;
        int n = s.length();
        for (int left = 0; left < n; left++) {
            Map<Character, Integer> map = new HashMap<>();
            for (int right = left; right < n; right++) {
                char curr = s.charAt(right);
                map.put(curr, map.getOrDefault(curr, 0) + 1);
                boolean check = true;
                int val = -1;
                for (char ch : map.keySet()) {
                    if (val == -1) val = map.get(ch);
                    if (map.get(ch) != val) {
                        check = false;
                        break;
                    }
                }
                if (check) ans = Math.max(ans, right - left + 1);
            }
        }
        return ans;
    }
}