package myStack;

import java.util.LinkedList;

/**
 * 中缀表达式转后缀表达式
 */
public class InfixExpression {
    public static void main(String[] args) {
        System.out.println(infixToSuffix("a+b"));
        System.out.println(infixToSuffix("a+b-c"));
        System.out.println(infixToSuffix("a+b*c"));
        System.out.println(infixToSuffix("a*b+c"));
        System.out.println(infixToSuffix("(a+b)*c"));
    }

    public static String infixToSuffix(String expression) {
        //此处处理加减乘除四种运算符
        //如果遇到非运算符，直接拼接为字符串
        //遇到 + - * /
        //  优先级比栈顶的运算符的优先级高，入栈
        //  如果运算符没有栈顶运算符的优先级高，先将优先级>=它的都出栈，它再入栈
        //  遍历完毕后，栈里面剩余的运算符依次出栈
        //  对于括号来讲;
        //      对于左括号来讲（但是左括号优先级设置地更低），直接入栈；
        //      对于右括号来讲，栈中直到左括号为止的所有运算符全部出栈，拼接为字符串即可
        LinkedList<Character> stack = new LinkedList<>();
        StringBuilder sb = new StringBuilder(expression.length());
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            switch (c) {
                case '*', '-', '+', '/' -> {
                    if (stack.isEmpty()) {
                        stack.push(c);
                    } else {
                        if (priority(c) > priority(stack.peek())) {
                            stack.push(c);
                        } else {
                            while (!stack.isEmpty() && priority(stack.peek()) >= priority(c)) {
                                sb.append(stack.pop());
                            }
                            stack.push(c);
                        }
                    }
                }
                case '(' -> stack.push(c);
                case ')' -> {
                    //在已经有左括号出现的情况下，不可能出现栈空的情况
                    //为了防止idea报出警告，加入非空判断
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        sb.append(stack.pop());
                    }
                    //将左括号弹出栈
                    stack.pop();
                }
                default -> sb.append(c);
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    private static int priority(char c) {
        return switch (c) {
            case '*', '/' -> 2;
            case '+', '-' -> 1;
            case '(' -> 0;
            default -> throw new IllegalArgumentException("不合法的运算符");
        };
    }
}
