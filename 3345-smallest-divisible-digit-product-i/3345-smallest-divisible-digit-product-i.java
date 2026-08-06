class Solution {
    public int smallestNumber(int n, int t) {
        while (true) {
            int product = 1;

            char[] digits = String.valueOf(n).toCharArray();

            for (int i = 0; i < digits.length; i++) {
                product = product * (digits[i] - '0');
            }

            if (product % t == 0) {
                return n;
            }

            n++;
        }
    }
}