class Solution {
    public int maximumGain(String s, int x, int y) {
        if (x >= y) {
            Pair p1 = remove(s, 'a', 'b', x);
            Pair p2 = remove(p1.str, 'b', 'a', y);
            return p1.score + p2.score;
        } else {
            Pair p1 = remove(s, 'b', 'a', y);
            Pair p2 = remove(p1.str, 'a', 'b', x);
            return p1.score + p2.score;
        }
    }

    public static class Pair {
        String str;
        int score;

        Pair(String str, int score) {
            this.str = str;
            this.score = score;
        }
    }

    public Pair remove(String s, char c1, char c2, int score) {
        StringBuilder stack = new StringBuilder();
        int total = 0;
        for (char ch : s.toCharArray()) {
            if (stack.length() > 0 && stack.charAt(stack.length() - 1) == c1 && ch == c2) {
                stack.deleteCharAt(stack.length() - 1);
                total += score;
            } else {
                stack.append(ch);
            }
        }
        return new Pair(stack.toString(), total);
    }
}
