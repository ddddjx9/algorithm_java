package myStack;

import java.util.Stack;

public class ReversePolishNotation {
    public static void main(String[] args) {
        // LeetCode150：逆波兰表达式求值：
        // 运算符在两个数字之间，中缀表达式1+2
        // 运算符写在数字后面12+

        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(new ReversePolishNotation().reversePolishNotation(tokens));
    }

    //遇到数字压入栈，如果遇到运算符，连续两次将数字弹出栈，计算后再将结果压入栈
    //当数组遍历完毕，那么说明表达式转换完毕
    public Integer reversePolishNotation(String[] tokens) {
        //处理负数的加减乘除很麻烦
        //使用自带解析数字的方法parseInt()
        final Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            switch (token) {
                case "+" -> {
                    Integer second = stack.pop();
                    Integer first = stack.pop();
                    //tokens[i] 是一个算符（"+"、"-"、"*" 或 "/"）
                    stack.push(first + second);
                }
                case "-" -> {
                    Integer second = stack.pop();
                    Integer first = stack.pop();
                    stack.push(first - second);
                }
                case "*" -> {
                    Integer second = stack.pop();
                    Integer first = stack.pop();
                    stack.push(first * second);
                }
                case "/" -> {
                    Integer second = stack.pop();
                    Integer first = stack.pop();
                    stack.push(first / second);
                }
                default -> stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}
