class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stk = new Stack<>();

        for (String token : tokens) {

            // Check if the token is an operator
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {

                // Pop right operand first
                int d2 = stk.pop();

                // Pop left operand second
                int d1 = stk.pop();

                int res = 0;

                if (token.equals("+")) {
                    res = d1 + d2;
                } else if (token.equals("-")) {
                    res = d1 - d2;
                } else if (token.equals("*")) {
                    res = d1 * d2;
                } else {
                    res = d1 / d2;
                }

                // Push the result back onto the stack
                stk.push(res);

            } else {
                // Token is a number, convert it from String to int and push it
                stk.push(Integer.parseInt(token));
            }
        }

        // Final result is the only element left in the stack
        return stk.pop();
    }
}