class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        StringBuilder cleaned = new StringBuilder();
        for(char c : s.toCharArray()) {
            if(Character.isLetterOrDigit(c)) {
                cleaned.append(c);
            }
        }
        String reversed = cleaned.reverse().toString();
        return cleaned.reverse().toString().equals(reversed);

    }
}