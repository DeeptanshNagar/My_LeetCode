class Solution {
    public int thirdMax(int[] arr) {
        long largest = Long.MIN_VALUE;
        long secondLargest = Long.MIN_VALUE;
        long thirdLargest = Long.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if(largest == arr[i] || secondLargest == arr[i] || thirdLargest == arr[i]) {
                continue;
            }
            if(arr[i] > largest) {
                thirdLargest = secondLargest;
                secondLargest = largest;
                largest = arr[i];
            } else if(arr[i] > secondLargest) {
                thirdLargest = secondLargest;
                secondLargest = arr[i];
            }  else if(arr[i] > thirdLargest) {
                thirdLargest = arr[i];
            }
        }
        if(thirdLargest == Long.MIN_VALUE) {
            return (int)largest;
        } else {
            return (int)thirdLargest;
        }
    }
}