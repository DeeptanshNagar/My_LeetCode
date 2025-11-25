class Solution {
    public int smallestRepunitDivByK(int k) {
        if ((k & 1) == 0 || k % 5 == 0) return -1;
        // int arr[] = {1, 11, 111, 1111, 11111, 111111, 1111111};
        if (k == 1) return 1;
        int num = 1;
        int i = 2;
        while (true) {
            num = (10 * num + 1) % k;
            if (num == 0) return i;
            i++;
        }
    }
}