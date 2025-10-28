class Solution {
    public int numberOfBeams(String[] bank) {
        int ans = 0;
        int prev = 0;
        for (char ch : bank[0].toCharArray()) if (ch == '1') prev++;

        for (int i = 1; i < bank.length; i++) {
            int curr = 0;
            for (char ch : bank[i].toCharArray()) if (ch == '1') curr++;
            if (curr == 0) continue;
            ans += (curr * prev);
            prev = curr;
        }

        return ans;
    }
}