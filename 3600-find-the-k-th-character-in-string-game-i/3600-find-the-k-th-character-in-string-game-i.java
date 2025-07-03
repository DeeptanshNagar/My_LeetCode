class Solution {
    public char kthCharacter(int k) {
       StringBuilder sb = new StringBuilder("a");
        while (sb.length() < k) {
            StringBuilder newSb = new StringBuilder();
            for (int i = 0; i < sb.length(); i++) {
                char newSbChar = (char)(((sb.charAt(i) - 'a' + 1) % 26) + 'a');
                newSb.append(newSbChar);
            }
            sb.append(newSb);
        }
        return sb.charAt(k - 1);
    }
}