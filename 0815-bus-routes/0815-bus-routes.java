public class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) return 0;

        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int route = 0; route < routes.length; route++) {
            for (int stop : routes[route]) {
                adjList.computeIfAbsent(stop, k -> new ArrayList<>()).add(route);
            }
        }

        Queue<Integer> q = new LinkedList<>();
        Set<Integer> vis = new HashSet<>();

        for (int route : adjList.getOrDefault(source, new ArrayList<>())) {
            q.add(route);
            vis.add(route);
        }

        int busCount = 1;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int route = q.poll();

                for (int stop : routes[route]) {
                    if (stop == target) return busCount;

                    for (int nextRoute : adjList.getOrDefault(stop, new ArrayList<>())) {
                        if (!vis.contains(nextRoute)) {
                            vis.add(nextRoute);
                            q.add(nextRoute);
                        }
                    }
                }
            }
            busCount++;
        }

        return -1;
    }
}
