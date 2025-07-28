class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();
    ArrayList<Integer> list = new ArrayList<>();
    private void helper(int arr[], int i) {
        if (i == arr.length) {
            if (list.size() == 0) return;
            int temp = list.get(0);
            for (int num : list) temp |= num;
            map.put(temp, map.getOrDefault(temp, 0) + 1);
            return;
        }
        helper(arr, i + 1);
        list.add(arr[i]);
        helper(arr, i + 1);
        list.removeLast();
    }

    public int countMaxOrSubsets(int[] nums) {
        helper(nums, 0);
        int max = 0;
        for (int num : map.keySet()) max = Math.max(max, num);
        return map.get(max);
    }

}