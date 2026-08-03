class Solution {
    public boolean lemonadeChange(int[] arr) {
        int n = arr.length;

        int five = 0;
        int ten = 0;
        int i = 0;

        while(i < n) {
            if(arr[i] == 5) {
                five++;
            } else if(arr[i] == 10) {
                if (five != 0) {
                    ten++;
                    five--;
                } else {
                    return false;
                }
            } else {
                if(five != 0 && ten != 0) {
                    ten--;
                    five--;
                }
                else if (five >= 3) {
                    five -= 3;
                } 
                else {
                    return false;
                }
            }
            i++;
        }
        return true;
    }
}