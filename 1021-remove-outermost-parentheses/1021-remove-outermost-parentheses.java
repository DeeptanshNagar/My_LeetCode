class Solution {
    public String removeOuterParentheses(String s) {
        int count = 0;
        StringBuilder ans = new StringBuilder();

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if(ch == ')') {
                count--;
            }

            if(count != 0) {
                ans.append(ch);
            }

            if(ch == '(') {
                count++;
            }
        }
        return ans.toString();
    }
}