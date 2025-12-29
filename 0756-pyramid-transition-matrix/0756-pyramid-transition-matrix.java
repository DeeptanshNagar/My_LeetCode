class Solution {
    private boolean helper(int i, char pyramid[][], Map<String, List<String>> allowed, StringBuilder curr) {
        if (i == 0) return true;
        if (curr.length() == i) {
            for (int j = 0; j < i; j++) pyramid[i - 1][j] = curr.charAt(j);
            return helper(i - 1, pyramid, allowed, new StringBuilder());
        }

        int j = curr.length();
        String key = "" + pyramid[i][j] + pyramid[i][j + 1];
        List<String> vals = allowed.get(key);
        if (vals == null) return false;
        for (String val : vals) {
            curr.append(val.charAt(0));
            if (helper(i, pyramid, allowed, curr)) return true;
            curr.deleteCharAt(curr.length() - 1);
        }
        return false;
    }

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        int n = bottom.length();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : allowed) {
            map.computeIfAbsent(s.substring(0, 2), k -> new ArrayList<>()).add(s.substring(2));
        }
        char pyramid[][] = new char[n][];
        for (int i = n; i > 0; i--) {
            pyramid[i - 1] = new char[i];
        }

        for (int i = 0; i < n; i++) pyramid[n - 1][i] = bottom.charAt(i);

        return helper(n - 1, pyramid, map, new StringBuilder());
    }
}