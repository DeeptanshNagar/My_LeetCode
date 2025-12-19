class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[2], b[2]));
        Set<Integer> know = new HashSet<>();
        know.add(0);
        know.add(firstPerson);

        int i = 0;
        while (i < meetings.length) {
            int t = meetings[i][2];
            Map<Integer, List<Integer>> g = new HashMap<>();
            Set<Integer> people = new HashSet<>();

            int j = i;
            while (j < meetings.length && meetings[j][2] == t) {
                int a = meetings[j][0], b = meetings[j][1];
                g.computeIfAbsent(a, k -> new ArrayList<>()).add(b);
                g.computeIfAbsent(b, k -> new ArrayList<>()).add(a);
                people.add(a);
                people.add(b);
                j++;
            }

            Deque<Integer> q = new ArrayDeque<>();
            Set<Integer> seen = new HashSet<>();
            for (int p : people) {
                if (know.contains(p)) {
                    q.add(p);
                    seen.add(p);
                }
            }

            while (!q.isEmpty()) {
                int u = q.poll();
                for (int v : g.getOrDefault(u, Collections.emptyList())) {
                    if (seen.add(v)) q.add(v);
                }
            }

            know.addAll(seen);
            i = j;
        }
        return new ArrayList<>(know);
    }
}