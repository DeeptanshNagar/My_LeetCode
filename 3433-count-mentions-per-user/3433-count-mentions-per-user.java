class Solution {
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        events.sort((a, b) -> {
            int ta = Integer.parseInt(a.get(1));
            int tb = Integer.parseInt(b.get(1));
            if (ta != tb) return Integer.compare(ta, tb);
            String ea = a.get(0), eb = b.get(0);
            if (ea.equals(eb)) return 0;
            return ea.equals("OFFLINE") ? -1 : 1;
        });


        int ans[] = new int[numberOfUsers];
        int curr = 0;
        Map<Integer, Integer> offline = new HashMap<>();
        for (int i = 0; i < numberOfUsers; i++) offline.put(i, -1);

        for (List<String> event : events) {
            if (event.get(0).equals("OFFLINE")) {
                int t = Integer.parseInt(event.get(1));
                curr = t;
                int i = Integer.parseInt(event.get(2));
                offline.put(i, t + 60);
            }
            else {
                int t = Integer.parseInt(event.get(1));
                curr = t;

                if (event.get(2).equals("ALL")) {
                    for (int i = 0; i < numberOfUsers; i++) ans[i]++;
                }
                else if (event.get(2).equals("HERE")) {
                    for (int num : offline.keySet()) {
                        if (offline.get(num) <= curr || offline.get(num) == -1) ans[num]++;
                    }
                }
                else {
                    String tokens[] = event.get(2).split(" ");
                    for (String token : tokens) {
                        int i = Integer.parseInt(token.substring(2));
                        ans[i]++;
                    }
                }
            }
        }
        return ans;
    }
}