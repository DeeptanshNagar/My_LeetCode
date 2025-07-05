class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        for(int num : nums) {
            if(even(num)){
                count++;
            }
        }
        return count;
    }
    static boolean even(int num) {
        int numberOfDigits = digits(num);
        /*
        if (numberOfDigits % 2 == 0) {
            return true;
        }
        return false;
        */
        return numberOfDigits % 2 == 0;
    }

    // 2 way to count number of digits in a number
    static int digits2(int num) {

        if (num < 0) {
            num = num * -1;
        }

        return (int)(Math.log10(num)) + 1;
    }

    // count number of digits in a number
    static int digits(int num) {

        if (num < 0) {
            num = num * -1;
        }

        if (num == 0) {
            return 1;
        }

        int count = 0;
        while (num > 0) {
            count++;
            num = num / 10;    // num /= 10
        }
        return count;
    }
}