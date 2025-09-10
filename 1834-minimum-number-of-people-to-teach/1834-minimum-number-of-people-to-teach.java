class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        Set<Integer> usersToTeach = new HashSet<>();
        for (int friendship[] : friendships) {
            int u1 = friendship[0] - 1;
            int u2 = friendship[1] - 1;
            boolean comm = false;
            
            for (int lang1 : languages[u1]) {
                for (int lang2 : languages[u2]) {
                    if (lang1 == lang2) {
                        comm = true;
                        break;
                    }
                }
                if (comm) break;
            }
            
            if (!comm) {
                usersToTeach.add(u1);
                usersToTeach.add(u2);
            }
        }
        
        int min = languages.length + 1;
        
        for (int lang = 1; lang <= n; lang++) {
            int count = 0;
            
            for (int user : usersToTeach) {
                boolean knows = false;
                for (int l : languages[user]) {
                    if (l == lang) {
                        knows = true;
                        break;
                    }
                }
                if (!knows) count++;
            }
            
            min = Math.min(min, count);
        }
        
        return min;
    }
}