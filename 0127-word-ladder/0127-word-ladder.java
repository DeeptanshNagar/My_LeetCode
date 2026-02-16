class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) return 0;
        
        Deque<String> q = new ArrayDeque<>();
        q.add(beginWord);
        
        Set<String> visited = new HashSet<>();
        q.add(beginWord);
        
        int changes = 1;
        while (!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++){
                String word = q.poll();
                if (word.equals(endWord)) return changes;
                
                for (int j = 0; j < word.length(); j++){
                    for (int k = 'a'; k <= 'z'; k++){
                        char arr[] = word.toCharArray();
                        arr[j] = (char) k;
                        
                        String str = new String(arr);
                        if (set.contains(str) && !visited.contains(str)){
                            q.add(str);
                            visited.add(str);
                        }
                    }
                }
            }
            changes++;
        }
        return 0;
    }
}