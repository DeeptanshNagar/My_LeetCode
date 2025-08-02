class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        HashMap<Integer, Integer> count = new HashMap<>();
        int n = basket1.length;
        int globalMin = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            count.put(basket1[i], count.getOrDefault(basket1[i], 0) + 1);
            count.put(basket2[i], count.getOrDefault(basket2[i], 0) - 1);
            globalMin = Math.min(globalMin, Math.min(basket1[i], basket2[i]));
        }

        List<Integer> excess = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            int key = entry.getKey();
            int val = entry.getValue();
            if (val % 2 != 0) return -1;
            for (int i = 0; i < Math.abs(val) / 2; i++) {
                excess.add(key);
            }
        }

        Collections.sort(excess);
        long cost = 0;
        for (int i = 0; i < excess.size() / 2; i++) {
            cost += Math.min(excess.get(i), 2 * globalMin); 
        }

        return cost;
    }
}