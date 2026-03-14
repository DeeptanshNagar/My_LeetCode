class Solution {
    int count = 0;

    public String getHappyString(int n, int k) {
        int size = 3 * (int)Math.pow(2, n - 1);

        if (k > size) return "";

        StringBuilder sb = new StringBuilder();
        return helper(n, k, sb);
    }

    public String helper(int n, int k, StringBuilder sb) {

        if (sb.length() == n) {
            count++;
            if (count == k) {
                return sb.toString();
            }
            return "";
        }

        if (sb.length() == 0 || sb.charAt(sb.length() - 1) != 'a') {
            sb.append('a');
            String s = helper(n, k, sb);
            if (!s.equals("")) return s;
            sb.deleteCharAt(sb.length() - 1);
        }

        if (sb.length() == 0 || sb.charAt(sb.length() - 1) != 'b') {
            sb.append('b');
            String s = helper(n, k, sb);
            if (!s.equals("")) return s;
            sb.deleteCharAt(sb.length() - 1);
        }

        if (sb.length() == 0 || sb.charAt(sb.length() - 1) != 'c') {
            sb.append('c');
            String s = helper(n, k, sb);
            if (!s.equals("")) return s;
            sb.deleteCharAt(sb.length() - 1);
        }
        return "";
    }
}