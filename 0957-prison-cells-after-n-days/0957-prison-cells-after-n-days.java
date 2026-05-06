class Solution {
    public int[] prisonAfterNDays(int[] cells, int n) {
        if(cells == null || cells.length == 0 || n <= 0) {
            return cells;
        }
        boolean hasCycle = false;
        int count = 0;
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < n; i++) {
            int[] next = nextDay(cells);
            String key = Arrays.toString(next);
            if(!set.contains(key)) {
                set.add(key);
                count++;
            } else {
                hasCycle = true;
                break;
            }
            cells = next;
        }
        if(hasCycle) {
            n = n % count;
            for(int i = 0; i < n; i++) {
                cells = nextDay(cells);
            }
        }
        return cells;
    }
    public int[] nextDay(int[] cells) {
        int[] tmp = new int[cells.length];
        for(int i = 1; i < cells.length - 1; i++) {
            if(cells[i-1] == cells[i+1]) {
                tmp[i] = 1;
            }
        }
        return tmp;
    }

}