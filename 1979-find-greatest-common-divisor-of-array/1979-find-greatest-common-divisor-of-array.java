class Solution {
    public int findGCD(int[] arr) {
        int n= arr.length;
        int min= arr[0], max= arr[n-1];

        for(int i=0; i<n; i++)
        {
            max= Math.max(max, arr[i]);
            min= Math.min(min, arr[i]);
        }

        int a= max, b= min;
        while(b!=0)
        {
            int temp= b;
            b= a%b;
            a= temp;
        }
        return a;
    }
}