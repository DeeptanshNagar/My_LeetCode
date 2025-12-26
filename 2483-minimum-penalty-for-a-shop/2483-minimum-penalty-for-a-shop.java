class Solution {
    public int bestClosingTime(String customers) {
        int n = customers.length();
        int min = 0, curr = 0;
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (customers.charAt(i) == 'Y') curr--;
            else curr++;

            if (curr < min) {
                min = curr;
                j = i + 1;
            }
        }
        return j;
    }
}