class Solution {
    public void merge(int[] arr1, int m, int[] arr2, int n) {
        int idx = m + n - 1;
        int i = m-1;
        int j = n-1;
        while(i >= 0 && j >= 0) {
            if(arr1[i] < arr2[j]) {
                arr1[idx] = arr2[j];
                idx--; j--;
            } else {
                arr1[idx] = arr1[i];
                idx--; i--;
            }
        }
        while (j >= 0) {
            arr1[idx] = arr2[j];
            idx--; j--;
        }
    }
}