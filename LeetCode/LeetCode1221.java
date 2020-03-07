package LeetCode;

import java.util.Stack;

public class LeetCode1221 {
    public int balancedStringSplit(String s) {
        Stack<Character> stack = new Stack<>();
        int res = 0;
        for (Character c : s.toCharArray()) {
            if (!stack.isEmpty() && !stack.peek().equals(c)) {
                stack.pop();
                if (stack.isEmpty()) res++;
            } else {
                stack.push(c);
            }
        }
        return res;
    }

}
