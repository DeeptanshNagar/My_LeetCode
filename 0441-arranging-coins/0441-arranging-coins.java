class Solution {
    public int arrangeCoins(int n) {
        long left = 0,right = n;
        while(left <= right){
            long mid = left + (right - left)/2;
            long k = mid * (mid + 1) / 2;
            if(k == n){
                return (int)mid;
            }
            else if(k > n){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
           
        }
        return (int)right;
    }
}