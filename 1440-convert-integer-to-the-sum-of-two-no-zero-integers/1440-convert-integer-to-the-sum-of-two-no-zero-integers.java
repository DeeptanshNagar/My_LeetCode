class Solution {
    public int[] getNoZeroIntegers(int n) {
        int a = 1;
        while (true) {
            int b = n - a;
            if(!containsZero(a) && !containsZero(b)){
                return new int[]{a, b};
            }
            a++; 
        }
    }
    
    boolean containsZero(int num) {
        while (num > 0) {
            if (num % 10 == 0) {
                return true; 
            }
            num = num / 10; 
        }
        return false;
    }
}
