package myStack;

import java.util.ArrayDeque;

/**
 * LeetCode20：有效的括号
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>(s.length());
        //从左向右遍历字符串中的每一个字符
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else {
                if (!stack.isEmpty() && c == stack.peek()) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        //如果栈是空的，说明所有括号都配对了，如果不是空的说明还有没配上对的
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses validParentheses = new ValidParentheses();
        System.out.println(validParentheses.isValid("(()())"));
        System.out.println(validParentheses.isValid("([{}))"));
        System.out.println(validParentheses.isValid("([{}])"));
        System.out.println(validParentheses.isValid("([][])"));
        System.out.println(validParentheses.isValid("([]{})"));
        System.out.println(validParentheses.isValid("([{]])"));
        System.out.println(validParentheses.isValid(")[]"));
        System.out.println(validParentheses.isValid("]"));
    }
}
