class Solution {
    public String sortVowels(String s) {
        List<Character> vowels = new ArrayList<>();
        for(char c : s.toCharArray()) {
            if(isVowel(c)) {
                vowels.add(c);
            }
        }
        Collections.sort(vowels);

        StringBuilder sb = new StringBuilder();
        int index = 0;
        for(char c : s.toCharArray()) {
            if(isVowel(c)) {
                sb.append(vowels.get(index++));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
    public boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }
}