class Solution {
    public int numSteps(String s) {
        int ans = 0, carry = 0;
        for (int i = s.length() - 1; i > 0; i--) {
            int bit = s.charAt(i) & 1;
            ans += 1 + (bit ^ carry);
            carry |= bit;
        }

        return ans + carry;
    }
}