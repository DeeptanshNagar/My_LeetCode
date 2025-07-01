class Solution {
    public int possibleStringCount(String word) {
        int count = 1;
        char temp = word.charAt(0);
        for (int i = 1; i < word.length(); i++) {
            char curr = word.charAt(i);
            if (curr == temp) count++;
            else temp = curr;
        }
        return count;
    }
}