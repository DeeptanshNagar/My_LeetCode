class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int n = arr.length;
        Map<Integer, List<List<Integer>>> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        Arrays.sort(arr);
        for (int i = 1; i < n; i++) {
            int diff = arr[i] - arr[i - 1];
            List<Integer> curr = new ArrayList<>();
            curr.add(arr[i - 1]);
            curr.add(arr[i]);
            min = Math.min(min, diff);
            map.computeIfAbsent(diff, k -> new ArrayList<>()).add(curr);
        }
        return map.get(min);
    }
}