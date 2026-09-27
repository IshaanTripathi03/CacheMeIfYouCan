class Solution {
    public String reverseParentheses(String s) {
         Stack<StringBuilder> stack = new Stack<>();

        // Start with the outermost level
        stack.push(new StringBuilder());

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                // Start a new level
                stack.push(new StringBuilder());

            } else if (ch == ')') {

                // Current innermost string
                StringBuilder current = stack.pop();

                // Reverse it
                current.reverse();

                // Append it to the previous level
                stack.peek().append(current);

            } else {

                // Normal character
                stack.peek().append(ch);
            }
        }

        return stack.peek().toString();
    }
}