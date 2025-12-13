class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        int n = code.length;
        List<Integer> idx = new ArrayList<>();
        Map<String, Integer> rank = Map.of(
            "electronics", 0,
            "grocery", 1,
            "pharmacy", 2,
            "restaurant", 3
        );

        for (int i = 0; i < n; i++) {
            String c = code[i], b = businessLine[i];
            if (c != null && b != null
                    && isActive[i]
                    && rank.containsKey(b)
                    && c.matches("^[a-zA-Z0-9_]+$")) {
                idx.add(i);
            }
        }

        idx.sort((i, j) -> {
            int ri = rank.get(businessLine[i]);
            int rj = rank.get(businessLine[j]);
            if (ri != rj) return Integer.compare(ri, rj);

            int cmp = code[i].compareTo(code[j]);
            if (cmp != 0) return cmp;

            return Integer.compare(i, j);
        });

        List<String> ans = new ArrayList<>(idx.size());
        for (int i : idx) ans.add(code[i]);
        return ans;
    }
}