class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> exactWords = new HashSet<>(Arrays.asList(wordlist));
        HashMap<String, String> caseMap = new HashMap<>();
        HashMap<String, String> vowelMap = new HashMap<>();

        for (String word : wordlist) {
            caseMap.putIfAbsent(word.toLowerCase(), word);
            String devowel = devowel(word.toLowerCase());
            vowelMap.putIfAbsent(devowel, word);
        }

        String[] result = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];
            if (exactWords.contains(query)) {
                result[i] = query;
            } else {
                String lower = query.toLowerCase();
                if (caseMap.containsKey(lower)) {
                    result[i] = caseMap.get(lower);
                } else {
                    String devowel = devowel(lower);
                    result[i] = vowelMap.getOrDefault(devowel, "");
                }
            }
        }
        return result;
    }
    String devowel(String s) {
        return s.replaceAll("[aeiou]", "*");
    }
}
