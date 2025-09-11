class Solution {
    public String sortVowels(String s) {
        List<Character> vowels = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if (isVowel(c)) vowels.add(c);
        }
        Collections.sort(vowels);
        StringBuilder result = new StringBuilder();
        int index = 0;
        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                result.append(vowels.get(index++));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }
}
