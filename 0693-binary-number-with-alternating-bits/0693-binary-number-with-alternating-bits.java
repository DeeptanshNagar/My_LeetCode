class Solution {
    public boolean hasAlternatingBits(int n) {
        char arr[] = Integer.toBinaryString(n).toCharArray();
        for (int i = 0; i < arr.length - 1; i++) if (arr[i] == arr[i + 1]) return false;
        return true;
    }
}