class Solution {
    public int singleNumber(int[] arr) {
        int result = 0;

        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int j = 0; j < arr.length; j++) {
                if ((arr[j] & (1 << i)) != 0) {
                    sum++;
                }
            }
            if (sum % 3 != 0) {
                result |= (1 << i);
            }
        }
        return result;
    }
}