class Solution {
    public List<List<Integer>> threeSum(int[] arr) {
        int n = arr.length;
        Set<List<Integer>> st = new HashSet<>();
        for(int i = 0; i < n; i++) {
            Set<Integer> hashset = new HashSet<>();
            for(int j = i+1; j < n; j++) {
                int third = -(arr[i]+arr[j]);
                if(hashset.contains(third)) {
                    List<Integer> temp = Arrays.asList(arr[i], arr[j], third);
                    Collections.sort(temp);
                    st.add(temp);
                }
                hashset.add(arr[j]);
            }
        }
        return new ArrayList<>(st);
    }
}