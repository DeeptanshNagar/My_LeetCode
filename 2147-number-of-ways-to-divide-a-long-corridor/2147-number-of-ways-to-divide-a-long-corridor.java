class Solution {
    public int numberOfWays(String corridor) {
        int mod = 1000000007;
        List<Integer> pos = new ArrayList<>();

        for (int i = 0; i < corridor.length(); i++) {
            if (corridor.charAt(i) == 'S') pos.add(i);
        }

        if (pos.size() % 2 == 1 || pos.size() == 0) return 0;

        long res = 1;
        for (int i = 2; i < pos.size(); i += 2) {
            int gap = pos.get(i) - pos.get(i - 1);
            res = (res * gap) % mod;
        }
        return (int) res;
    }
}