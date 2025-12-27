class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        int count[] = new int[n];
        PriorityQueue<Integer> free = new PriorityQueue<>();
        PriorityQueue<long[]> busy = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]) != 0 ? Long.compare(a[0], b[0]) : Long.compare(a[1], b[1]));

        for (int i = 0; i < n; i++) free.offer(i);

        for (int meeting[] : meetings) {
            int start = meeting[0], end = meeting[1];
            while (!busy.isEmpty() && busy.peek()[0] <= start) {
                free.offer((int) busy.poll()[1]);
            }
            if (!free.isEmpty()) {
                int room = free.poll();
                busy.offer(new long[]{end, room});
                count[room]++;
            } 
            else {
                long[] next = busy.poll();
                long newEnd = next[0] + (end - start);
                busy.offer(new long[]{newEnd, next[1]});
                count[(int) next[1]]++;
            }
        }

        int max = 0, res = 0;
        for (int i = 0; i < n; i++) {
            if (count[i] > max) {
                max = count[i];
                res = i;
            }
        }
        return res;
    }
}