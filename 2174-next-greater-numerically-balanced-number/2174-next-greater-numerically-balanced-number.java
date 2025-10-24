class Solution {
    public int nextBeautifulNumber(int n) {
        n = n + 1;
        while (true) {
            if (isBalanced(n)) {
                return n;
            }
            n++;
        }
    }
    boolean isBalanced(int num) {
        int[] count = new int[10];
        int temp = num;
        while (temp > 0) {
            int digit = temp % 10;
            if (digit == 0) {
                return false;
            }
            count[digit]++;
            temp = temp / 10;
        }
        for (int i = 1; i <= 9; i++) {
            if (count[i] != 0 && count[i] != i) {
                return false;
            }
        }
        return true;
    }
}
