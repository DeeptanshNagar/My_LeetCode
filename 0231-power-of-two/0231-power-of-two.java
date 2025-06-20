class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n<1){
            return false;
        }
        while(n>1) {
            int remainder = n%2;
            if(remainder != 0) {
                return false;
            } else {
                n = n / 2;
            }
        }
        return true;
    }
}